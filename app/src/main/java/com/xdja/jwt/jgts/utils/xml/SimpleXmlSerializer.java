package com.xdja.jwt.jgts.utils.xml;

import android.util.Xml;

import com.gouhao.frame.utils.LogUtil;

import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by gouhao on 3/27/2017.
 */

public class SimpleXmlSerializer {
    private static final String TAG = SimpleXmlSerializer.class.getSimpleName();

    public static <T extends Object> String serializer(T bean, Class<T> c, String root) {
        if(root == null || bean == null || c == null) {
            return null;
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(outputStream, "UTF-8");
            serializer.startDocument("UTF-8", false);
            serializer.startTag(null, root);
            Field[] fields = c.getDeclaredFields();
            for(Field f : fields) {
                String tag = f.getName();
                XmlField annotation = f.getAnnotation(XmlField.class);
                if(annotation != null) {
                    tag = annotation.name();
                }
                serializer.startTag(null, tag);
                setValueToSerializer(bean, serializer, f);
                serializer.endTag(null, tag);
            }
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

    private static <T extends Object> void setValueToSerializer(T bean, XmlSerializer serializer, Field f)
            throws IOException, IllegalAccessException {
        f.setAccessible(true);
        String filedString = f.getGenericType().toString();
        if(filedString.equals("class java.lang.String")) {
            String text = (String) f.get(bean);
            serializer.text(text == null ? "" : text);
        }else if(filedString.equals("int")){
            serializer.text(String.valueOf(f.getInt(bean)));
        } else if(filedString.equals("float") || filedString.equals("double")){
            serializer.text(String.valueOf(f.getFloat(bean)));
        } else if(filedString.equals("boolean")){
            serializer.text(String.valueOf(f.getBoolean(bean)));
        }
    }
}
