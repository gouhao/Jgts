package com.xdja.jwt.jgts.utils.gprsutils.request;


public class Api {

    public interface Apis {
        String PC = "dxcx_ywff_jyxx";//警员信息
        String MPSUER = "dxcx_ywff_qfyhxx";//群防用户信息
        String RESOURCES = "dxcx_ywff_zyxx";//资源信息
        String COLLECTIONS = "dxcx_ywff_cjxx";//采集信息
        String TASKS = "dxcx_ywff_rwxx";//任务信息
        String CODE = "dxcx_ywff_bmxx";//编码信息
        String TASK_ATTACHMENT = "dxcx_ywff_rwwjxx";//任务附件
        String COLLECTION_ATTACHMENT = "dxcx_ywff_cjwjxx";//采集信息附件
        String ACCEPTOR = "dxcx_ywff_rwcyxx";//任务接收者
        String VERIFY = "dxcx_ywff_qfyhshxx";//群防用户审核信息
    }

    public interface RequestKeys {
        String ReqType = "ReqType";
        String SessionID = "SessionID";

        String BeginNo = "BeginNo";
        String ReqTable = "ReqTable";
        String ValidateType = "ValidateType";
        String ValidateValue = "ValidateValue";
        String DataSource = "DataSource";


        //0221-17 小写列名
        String Id = "c_id";
        String Type = "c_type";
        String State = "c_state";
        String Status = "c_status";
        String FileId = "c_fileid";
        String Creator = "c_creator";
        String Updater = "c_updator";
        String TaskId = "c_taskid";
        String Account = "c_account";
        String PesAccount = "c_pesaccount";
        String Category = "c_category";
        String CodeName = "c_codename";
        String ReceiveStatus = "c_processreceivestatus";
        String CollectionId = "c_collectinfoid";
        String OrgStructure = "c_orgstructure";
        //String OrgStructure = "c_OrgStructure";
        String PoliceStationCode = "c_policestationcode";
    }
}
