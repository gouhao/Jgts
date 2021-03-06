package com.xdja.jwt.jgts.utils.xml;

import android.util.Xml;

import com.gouhao.frame.utils.LogUtil;

import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

/**
 * Created by gouhao on 3/27/2017.
 */

public class SimpleXmlSerializer {
    private static final String TAG = SimpleXmlSerializer.class.getSimpleName();

    public static String serializer(Object bean, Class c, String root) {
        if(root == null || bean == null || c == null) {
            return null;
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(outputStream, "UTF-8");
            serializer.startDocument("UTF-8", false);
            serializer.startTag(null, root);
            setFieldTag(bean, serializer, c);
            serializer.endTag(null, root);
            serializer.endDocument();
            serializer.flush();
            LogUtil.i(TAG, outputStream.toString());
            return outputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setFieldTag(Object bean, XmlSerializer serializer, Class c) throws IOException, IllegalAccessException{
        Field[] fields = c.getDeclaredFields();
        for(Field f : fields) {
            String tag = f.getName();
            XmlField annotation = f.getAnnotation(XmlField.class);
            if(annotation != null) {
                tag = annotation.name();
            }
            setTag(bean, serializer, f, tag);
        }
        Class<?> superclass = c.getSuperclass();
        if(superclass != Object.class) {
            setFieldTag(bean, serializer, superclass);
        }
    }

    private static void setTag(Object bean, XmlSerializer serializer, Field f, String tag) throws IOException, IllegalAccessException {
        serializer.startTag(null, tag);
        setValueToSerializer(bean, serializer, f);
        serializer.endTag(null, tag);
    }

    private static void setValueToSerializer(Object bean, XmlSerializer serializer, Field f)
            throws IOException, IllegalAccessException {
        f.setAccessible(true);
        String filedTypeString = f.getGenericType().toString();
        if(filedTypeString.equals("class java.lang.String")) {
            String text = (String) f.get(bean);
            serializer.text(text == null ? "" : text);
        }else if(filedTypeString.equals("int")){
            serializer.text(String.valueOf(f.getInt(bean)));
        } else if(filedTypeString.equals("float") || filedTypeString.equals("double")){
            serializer.text(String.valueOf(f.getFloat(bean)));
        } else if(filedTypeString.equals("boolean")){
            serializer.text(String.valueOf(f.getBoolean(bean)));
        } else if(filedTypeString.contains("java.util.List")) {
            ParameterizedType pt = (ParameterizedType) f.getGenericType();
            Class c = (Class) pt.getActualTypeArguments()[0];
            List list = (List) f.get(bean);
            if(list != null) {
                for(Object o : list) {
                    serializer.startTag(null, c.getSimpleName());
                    setFieldTag(o, serializer, c);
                    serializer.endTag(null, c.getSimpleName());
                }
            }

        }
    }
}
