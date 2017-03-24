package com.xdja.jwt.jgts.utils.gprsutils.repository;


import android.text.TextUtils;

import com.gouhao.frame.base.LogUtil;
import com.xdja.jwt.jgts.utils.gprsutils.entity.Pagination;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/*
* 1206-16 把xml字符串转化为所需实体列表的工具
* */
public class BeanUtil {
    private final static String TAG = BeanUtil.class.getSimpleName();

    public static <T> Pagination<T> convert(final Class<T> clz, String xml) {
        return convertSync(clz, xml);
    }

    //////////////////////////sync begin
    public static <T> Pagination<T> convertSync(Class<T> clz, String xml) {
        return convert(clz, parse(xml));
    }

    public static XMLResponse parse(String xml) {
        if (TextUtils.isEmpty(xml)) {
            throw new IllegalArgumentException();
        }
        LogUtil.i(TAG, String.format("Request result: %s", xml));
        if (xml.startsWith("0x00000000")) {//0x00000000 未找到记录
            return new XMLResponse();
        }
        if (!xml.startsWith("<?xml")) {
            throw new IllegalArgumentException();
        }
        return XMLParser.parse(xml);
    }

    public static <T> Pagination<T> convert(Class<T> clz, XMLResponse response) {
        if (response == null) {
            throw new IllegalArgumentException();
        }
        if (response.isEmpty()) {
            return new Pagination<>();
        }
        if (response.getRows().size() < 2) {
            throw new IllegalArgumentException();
        }
        Pagination<T> result = new Pagination<>(response.getPage());
        result.relations = response.relations;

        if (response.getRows().size() == 2) {
            return result;
        }

        LinkedHashMap<Integer, String> columnMap = response.getDataMap(0);

        LogUtil.i(TAG, "convert bean: " + clz.getSimpleName() + " rows: " + response.getRows().size());
        for (int i = 2; i < response.getRows().size(); i++) {
            try {
                LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
                for (int columnIndex = 0; columnIndex < response.getDataMap(i).size(); columnIndex++) {
                    fieldMap.put(columnMap.get(columnIndex), response.getDataMap(i).get(columnIndex));
                }
                result.add(setValue(clz, fieldMap));
            } catch (Exception e) {
                LogUtil.e(TAG, String.format("convert bean:%s err:%s", clz.getSimpleName(), e.getMessage()));
            }
        }
        return result;
    }
    private static <T> T setValue(Class<T> clz, LinkedHashMap<String, String> fieldMap) throws Exception {
        T instance = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();

        Field idField = getDeclaredField(instance, "id");
        if (idField != null && fieldMap.containsKey("c_id")) {
            setFieldValue(idField, instance, fieldMap.get("c_id"));
        }

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String columnName = "c_" + field.getName().toLowerCase();
            if (!fieldMap.containsKey(columnName)) {
                continue;
            }
            setFieldValue(field, instance, fieldMap.get(columnName));
        }
        return instance;
    }

    public static boolean setFieldValue(Field field, Object instance, String value) throws Exception {
        field.setAccessible(true);
        String type = field.getType().toString();
        if (type.endsWith("String")) {
            field.set(instance, value);
            return true;
        }
        if (type.endsWith("int") || type.endsWith("Integer")) {
            field.set(instance, Integer.parseInt(value));
            return true;
        }
        if (type.endsWith("long") || type.endsWith("Long")) {
            field.set(instance, Long.parseLong(value));
            return true;
        }
        if (type.endsWith("double") || type.endsWith("Double")) {
            field.set(instance, Double.parseDouble(value));
            return true;
        }
        if (type.endsWith("float") || type.endsWith("Float")) {
            field.set(instance, Float.parseFloat(value));
            return true;
        }
        return false;
    }

    public static Field getDeclaredField(Object object, String fieldName) {
        Class<?> clz = object.getClass();
        for (; clz != Object.class; clz = clz.getSuperclass()) {
            try {
                Field field = clz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
