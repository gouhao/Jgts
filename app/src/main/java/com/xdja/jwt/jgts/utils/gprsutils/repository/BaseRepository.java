package com.xdja.jwt.jgts.utils.gprsutils.repository;


import com.xdja.publicclass.SocketManager;

import java.lang.reflect.Field;
import java.util.List;

/*
* 基础仓库
* */
public class BaseRepository {

    protected int isSafe;
    protected String ip;
    protected String port;

    public BaseRepository() {
        init();
    }

    private void init() {
//        isSafe = UserCache.isSafeCon;
//        ip = UserCache.serverIP;
//        port = UserCache.serverPort;
    }

    protected String sessionID() {
//        return UserCache.sessionID;
        return null;
    }

    private void setTimeout(SocketManager socketManager) {
        try {
            Field readTimeout = socketManager.getClass().getDeclaredField("getDateTimeout");
            Field connectionTimeout = socketManager.getClass().getDeclaredField("timeout");
            readTimeout.setAccessible(true);
            readTimeout.setInt(socketManager, 60000);
            connectionTimeout.setAccessible(true);
            connectionTimeout.setLong(socketManager, 20000);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String sendSync(String xml) {
        return new SocketManager(isSafe, ip, port).execute(xml);
    }

    public String send(String xml) {
        return new SocketManager(isSafe, ip, port).execute(xml);
    }

    /*
    * split by ,
    * */
    public static String buildIds(List<? extends Object> list) {
        int iMax = list.size() - 1;
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(list.get(i).toString());
            if (i == iMax)
                return b.toString();
            b.append(",");
        }
    }
}
