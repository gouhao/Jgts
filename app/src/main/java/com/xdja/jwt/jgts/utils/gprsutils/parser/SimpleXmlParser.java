package com.xdja.jwt.jgts.utils.gprsutils.parser;

import com.gouhao.frame.utils.LogUtil;
import com.xdja.jwt.jgts.annotation.XmlField;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

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
            String tagName = null;
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        break;
                    case XmlPullParser.TEXT:
                        String tagText = parser.getText();
                        LogUtil.i(TAG, "tagName=" + tagName + ", tagText=" + tagText);
                        if(tagText != null) {
                            try {
                                Field field = findFieldByName(c, tagName);
                                if(field != null) {
                                    field.setAccessible(true);
                                    if(field != null){
                                        String filedString = field.getGenericType().toString();
                                        if(filedString.equals("class java.lang.String")) {
                                            field.set(o, tagText);
                                        }else if(filedString.equals("int")){
                                            field.set(o, Integer.parseInt(tagText));
                                        } else if(filedString.equals("float") || filedString.equals("double")){
                                            field.set(o, Float.parseFloat(tagText));
                                        } else if(field.equals("boolean")){
                                            field.set(o, Boolean.parseBoolean(tagText));
                                        }
                                    }
                                }
                            }catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tagName = null;
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
}
