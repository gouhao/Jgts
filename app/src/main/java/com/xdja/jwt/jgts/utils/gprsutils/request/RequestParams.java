package com.xdja.jwt.jgts.utils.gprsutils.request;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestParams {

    public static class ConditionType {
        public static final int STRING = 1;
        public static final int NUMBER = 2;
        public static final int DATE = 3;
        public static final int PY = 4;
    }

    public static class ConditionOption {
        public static final int EQ = 1;//"="
        public static final int NE = 2;//"!="
        public static final int GTE = 3;//">="
        public static final int LTE = 4;//"<="

        public static final int IN = 8;//"in"
        public static final int LT = 9;//"<"
        public static final int GT = 10;//">"
    }

    public static class ConditionJoint {
        public static final int AND = 1;
        public static final int OR = 2;
        public static final int NONE = -1;
    }

    public static final int PAGE_SIZE = 10;

    private Map<String, Object> params = new LinkedHashMap<>();
    private List<String> conditions = new LinkedList<>();

    public static RequestParams create() {
        RequestParams params = new RequestParams();
        return params;
    }

    ///////////////////////biz
    public static RequestParams create(String api) {
        return create().api(api);
    }

    public static RequestParams create(String api, String sessionId) {
        return create().api(api).sessionID(sessionId);
    }

    public static RequestParams create(String api, String sessionId, int page) {
        return create().api(api).sessionID(sessionId).page(page);
    }

    public static RequestParams api(String api) {
        RequestParams params = new RequestParams();
        params.put(Api.RequestKeys.ReqType, api);
        params.put(Api.RequestKeys.DataSource, "*");
        return params;
    }

    public RequestParams sessionID(String sessionID) {
        params.put(Api.RequestKeys.SessionID, sessionID);
        return this;
    }

    public RequestParams page(int page) {
        params.put(Api.RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        return this;
    }
    ///////////////////////biz


    public RequestParams put(String key, int value) {
        params.put(key, String.valueOf(value));
        return this;
    }

    public RequestParams put(String key, String value) {
        params.put(key, value);
        return this;
    }

    /*
    * 默认为=，无joint
    * */
    public RequestParams addCondition(String columnName, String value) {
        return addCondition(ConditionType.STRING,
                columnName,
                ConditionOption.EQ,
                value,
                ConditionJoint.NONE);
    }

    public RequestParams addCondition(String columnName, int relation, String value, int joint) {
        return addCondition(ConditionType.STRING,
                columnName,
                relation,
                value,
                joint);
    }

    public RequestParams addCondition(int type, String columnName, int relation, String value, int joint) {
        StringBuilder condition = new StringBuilder();
        condition.append("<" + columnName);
        condition.append("  Type=" + "'" + type + "'");
        condition.append(" Relation=" + "'" + relation + "'");
        if (joint > 0) {
            condition.append(" SplitJoint=" + "'" + joint + "'");
        }
        condition.append(">" + value + "</" + columnName + ">");
        conditions.add(condition.toString());
        return this;
    }

    public Map<String, Object> get() {
        return params;
    }

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<Root>");
        for (String key : params.keySet()) {
            stringBuilder.append("<" + key + ">")
                    .append(params.get(key))
                    .append("</" + key + ">");
        }
        if (conditions.size() > 0) {
            stringBuilder.append("<Condition>");
            for (String condition : conditions) {
                stringBuilder.append(condition);
            }
            stringBuilder.append("</Condition>");
        }
        stringBuilder.append("</Root>");
        return stringBuilder.toString();
    }
}
