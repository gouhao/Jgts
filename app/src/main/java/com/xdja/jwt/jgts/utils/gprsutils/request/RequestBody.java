package com.xdja.jwt.jgts.utils.gprsutils.request;

import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.xdja.jwt.jgts.utils.gprsutils.request.Api.*;

public class RequestBody {

    static class ConditionType {
        public static final int STRING = 1;
        public static final int NUMBER = 2;
        public static final int DATE = 3;
        public static final int PY = 4;
    }

    static class ConditionOption {
        public static final int EQ = 1;//"="
        public static final int NE = 2;//"!="
        public static final int GTE = 3;//">="
        public static final int LTE = 4;//"<="

        public static final int IN = 8;//"in"
        public static final int LT = 9;//"<"
        public static final int GT = 10;//">"
    }

    static class ConditionJoint {
        public static final int AND = 1;
        public static final int OR = 2;
        public static final int NONE = -1;
    }

    public static final int PAGE_SIZE = 10;

    public static String pcRequestBody(String sessionID, String account) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.PC);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        builder.addCondition(RequestKeys.Account, account);
        return builder.build();
    }

    public static String pesUser(String sessionID, int page, String policeStationCode) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.PC);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.OrgStructure, policeStationCode);
        return builder.build();
    }

    /**
     * 通过帐号获取群防用户详情
     *
     * @param accounts - 群防用户帐号列表
     */
    public static String mpsUserRequestBody(String sessionID, int page, List<String> accounts) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.MPSUER);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        if (accounts != null && accounts.size() > 0) {
            for (int i = 0; i < accounts.size(); i++) {
                builder.addCondition(RequestKeys.Account, accounts.get(i), i == 0 ? ConditionJoint.NONE : ConditionJoint.OR);
            }
        }
        return builder.build();
    }

    /**
     * 通过派出所编码或民警帐号获取审核用户列表
     *
     * @param policeStationCode - 派出所编码 - NotNull
     * @param pesAccount        - 民警帐号 - Nullable
     */
    public static String verifyRequestBody(String sessionID, int page,
                                           String policeStationCode, String pesAccount) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.VERIFY);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.PoliceStationCode, policeStationCode);
        if (!TextUtils.isEmpty(pesAccount)) {
            builder.addCondition(RequestKeys.PesAccount, pesAccount);
        }
        return builder.build();
    }

    public static String resourcesRequestBody(String sessionID, List<String> fileIds) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.RESOURCES);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (fileIds != null && fileIds.size() > 0) {
            for (int i = 0; i < fileIds.size(); i++) {
                builder.addCondition(RequestKeys.FileId, fileIds.get(i), i == 0 ? ConditionJoint.NONE : ConditionJoint.OR);
            }
        }
        Log.e("dxcx_ywff_zyxx", builder.build());
        return builder.build();
    }

    public static String collectionsRequestBody(String sessionID, int page, String taskId) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.COLLECTIONS);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.TaskId, taskId);
        return builder.build();
    }

    public static String tasksRequestBody(String sessionID, int page, String taskId, String account, int type, int state) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.TASKS);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        if (!TextUtils.isEmpty(taskId)) {
            builder.addCondition(RequestKeys.TaskId, taskId);
        }
        if (!TextUtils.isEmpty(account)) {
            builder.addCondition(RequestKeys.Creator, account);
        }
        if (type >= 0) {
            builder.addCondition(RequestKeys.Type, String.valueOf(type));
        }
        if (state >= 0) {
            builder.addCondition(RequestKeys.State, String.valueOf(state));
        }
        return builder.build();
    }

    public static String taskAcceptorsRequestBody(String sessionID, int page, String taskId, int status) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.ACCEPTOR);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.TaskId, taskId);
        if (status >= 0) {
            builder.addCondition(RequestKeys.ReceiveStatus, String.valueOf(status));
        }
        return builder.build();
    }

    public static String taskAttachmentsRequestBody(String sessionID, String taskId) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.TASK_ATTACHMENT);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        builder.addCondition(RequestKeys.TaskId, taskId);
        return builder.build();
    }

    public static String collectionAttachmentsRequestBody(String sessionID, String collectionId) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.COLLECTION_ATTACHMENT);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        builder.addCondition(RequestKeys.CollectionId, collectionId);
        return builder.build();
    }

    public static String codeRequestBody(String sessionID, int page, String category, String codeName) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.CODE);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.Category, category);
        if (!TextUtils.isEmpty(codeName)) {
            builder.addCondition(RequestKeys.CodeName, codeName);
        }
        return builder.build();
    }

    public static String orgRequestBody(String sessionID, String category, int page) {
        XMLRequestBodyBuilder builder = new XMLRequestBodyBuilder();
        builder.put(RequestKeys.ReqType, Apis.CODE);
        builder.put(RequestKeys.SessionID, sessionID);
        builder.put(RequestKeys.DataSource, "*");
        if (page >= 1) {
            builder.put(RequestKeys.BeginNo, (page - 1) * PAGE_SIZE);
        }
        builder.addCondition(RequestKeys.Category, category);
        return builder.build();
    }

    static class XMLRequestBodyBuilder {
        private Map<String, Object> params = new LinkedHashMap<>();
        private List<String> conditions = new LinkedList<>();

        public XMLRequestBodyBuilder() {
        }

        public XMLRequestBodyBuilder put(String key, int value) {
            params.put(key, String.valueOf(value));
            return this;
        }

        public XMLRequestBodyBuilder put(String key, String value) {
            params.put(key, value);
            return this;
        }

        /*
        * 默认为=，无joint
        * */
        public XMLRequestBodyBuilder addCondition(String columnName, String value) {
            return addCondition(ConditionType.STRING, columnName, ConditionOption.EQ, value, ConditionJoint.NONE);
        }

        /*
        * 默认为=，有joint
        * */
        public XMLRequestBodyBuilder addCondition(String columnName, String value, int joint) {
            return addCondition(ConditionType.STRING, columnName, ConditionOption.EQ, value, joint);
        }

        /*
        * 有条件，无joint
        * */
        public XMLRequestBodyBuilder addCondition(String columnName, int relation, String value) {
            return addCondition(ConditionType.STRING, columnName, relation, value, ConditionJoint.NONE);
        }

        public XMLRequestBodyBuilder addCondition(int type, String columnName, int relation, String value, int joint) {
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
}
