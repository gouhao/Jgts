package com.xdja.jwt.jgts.utils.xml;

import android.databinding.repacked.org.antlr.v4.runtime.ListTokenSource;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gouhao on 3/24/2017.
 */

public class SimpleXmlParser {
    private static final String TAG = SimpleXmlParser.class.getSimpleName();

    public static <T extends Object> T parse(InputStream xml, IXmlParserAdapter<T> adapter) {
        if(adapter == null) {
            throw new NullPointerException("adapter is null");
        }
        adapter.onStartParse();
        try{
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xml, "UTF-8");
            int type = parser.getEventType();
            String tagName = null;
            while(type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        break;
                    case XmlPullParser.TEXT:
                        if(tagName != null) {
                            adapter.onTextTag(tagName, parser.getText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        adapter.onEndTag(tagName);
                        tagName = null;
                        break;
                }
                type = parser.next();
            }
            return adapter.getObject();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object parse(String xml, Class c) {
        try {
            return parse(new ByteArrayInputStream(xml.getBytes("UTF-8")), c);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object parse(InputStream xml, Class c) {
        try {
            Object o = c.newInstance();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xml, "UTF-8");
            int type = parser.getEventType();
            Class currentClass = c;
            Object currentObject = o;

            Stack<ParseBean> parseBeanStack = new Stack<>();
            ParseBean parseBean = new ParseBean(c, null, null, o, null);
            parseBeanStack.push(parseBean);

            String listType = null;
            while (type != XmlPullParser.END_DOCUMENT) {

                currentClass = parseBeanStack.peek().c;
                currentObject = parseBeanStack.peek().obj;
                switch (type) {
                    case XmlPullParser.START_TAG:
                        String name = parser.getName();
                        if(listType != null && name.equals(listType)) {
                            Class contentClass = parseBeanStack.peek().contentClass;
                            ParseBean bean = new ParseBean(contentClass, name, null, contentClass.newInstance(), null);
                            parseBeanStack.push(bean);
                            break;
                        }
                        Field field = findFieldByName(currentClass, name);
                        if(field != null) {
                            field.setAccessible(true);
                            String filedString = field.getGenericType().toString();
                            if(filedString.equals("class java.lang.String")) {
                                field.set(currentObject,  parser.nextText());
                            }else if(filedString.equals("int")){
                                field.set(currentObject, Integer.parseInt(parser.nextText()));
                            } else if(filedString.equals("float") || filedString.equals("double")){
                                field.set(currentObject, Float.parseFloat(parser.nextText()));
                            } else if(filedString.equals("boolean")){
                                field.set(currentObject, Boolean.parseBoolean(parser.nextText()));
                            } else if(filedString.contains("java.util.List")) {


                                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                                Class cl = (Class) pt.getActualTypeArguments()[0];

                                ParseBean bean = new ParseBean(List.class, parser.getName(), field, new ArrayList<>(), cl);
                                parseBeanStack.push(bean);

                                parser.next();
                                ParseBean p = new ParseBean(cl,parser.getName(), null, cl.newInstance(), null);
                                parseBeanStack.push(p);
                                listType = parser.getName();
                            }
                        }
                        break;
                    case XmlPullParser.TEXT:
                        break;
                    case XmlPullParser.END_TAG:
                        if(!parseBeanStack.isEmpty()){
                            ParseBean p = parseBeanStack.peek();
                            if(p.tagName != null && p.tagName.equals(parser.getName())) {
                                p = parseBeanStack.pop();
                                Object obj = p.obj;
                                if(p.c == List.class) {
                                    p.field.set(parseBeanStack.peek().obj, p.obj);
                                    listType = null;
                                } else {
                                    List list = (List) parseBeanStack.peek().obj;
                                    list.add(obj);
                                }

                            }
                        }
                        break;
                }
                type = parser.next();
            }
            return o;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setFieldValue(Object o, XmlPullParser parser, Field field) throws IllegalAccessException {
        try {
            if(field != null) {
                field.setAccessible(true);
                String filedString = field.getGenericType().toString();
                if(filedString.equals("class java.lang.String")) {
                    field.set(o,  parser.nextText());
                }else if(filedString.equals("int")){
                    field.set(o, Integer.parseInt(parser.nextText()));
                } else if(filedString.equals("float") || filedString.equals("double")){
                    field.set(o, Float.parseFloat(parser.nextText()));
                } else if(filedString.equals("boolean")){
                    field.set(o, Boolean.parseBoolean(parser.nextText()));
                } else if(filedString.contains("java.util.List")) {
                    List list = new ArrayList();
                    ParameterizedType pt = (ParameterizedType) field.getGenericType();
                    Class c = (Class) pt.getActualTypeArguments()[0];
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Field findFieldByName(Class c, String name){
        Field[] fields = c.getDeclaredFields();
        for(Field f : fields) {
            XmlField xmlField = f.getAnnotation(XmlField.class);
            if(xmlField != null) {
                if(xmlField.name().equals(name)) return f;
            } else {
                if(f.getName().equals(name)) return f;
            }
        }
        return null;
    }

    static class ParseBean {
        public ParseBean(Class c, String tagName, Field field, Object obj, Class cc) {
            this.c = c;
            this.tagName = tagName;
            this.field = field;
            this.obj = obj;
            this.contentClass = cc;
        }

        Class c;
        String tagName;
        Field field;
        Object obj;
        Class contentClass;
    }
}
