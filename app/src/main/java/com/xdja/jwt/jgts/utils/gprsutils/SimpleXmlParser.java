package com.xdja.jwt.jgts.utils.gprsutils;

import com.gouhao.frame.utils.LogUtil;

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

    public static Object parse(InputStream xml, Class c) {
        try {
            Object o = c.newInstance();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xml, "UTF-8");
            int type = parser.getEventType();
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_DOCUMENT:
                        LogUtil.i(TAG, "start document");
                        break;
                    case XmlPullParser.START_TAG:
                        if(parser.getDepth() == 1) break;
                        String tagName = parser.getName();
                        String tagText = parser.nextText();
                        LogUtil.i(TAG, "tagName=" + tagName + ", tagText=" + tagText);
                        if(tagText != null) {
                            try {
                                Field field = c.getDeclaredField(tagName);
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
                            }catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        LogUtil.i(TAG, "end document");
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

    public static Object parse(String xml, Class c) {
        try {
            return parse(new ByteArrayInputStream(xml.getBytes("UTF-8")), c);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
