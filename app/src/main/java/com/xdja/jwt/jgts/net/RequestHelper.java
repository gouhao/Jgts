package com.xdja.jwt.jgts.net;

import com.xdja.jwt.jgts.utils.xml.SimpleXmlSerializer;
import com.xdja.publicclass.SocketManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gouhao on 3/28/2017.
 */

public class RequestHelper {
    private final static String TAG = RequestHelper.class.getSimpleName();

    private static RequestHelper instance = new RequestHelper();

    private static int MAX_THREAD_COUNT = 3;

    private int IS_SAFE = 1;
    private String IP = "";
    private String PORT = "";
    private SocketManager socketManager = new SocketManager(IS_SAFE, IP, PORT);

    private ExecutorService threadPool;

    private RequestHelper(){
        threadPool = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
    }

    public static RequestHelper getInstance(){
        return instance;
    }

    public void request(final Object o, final Class c, final String xmlRoot, final Callback callback) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String xml = SimpleXmlSerializer.serializer(o, c, xmlRoot);
                String response = socketManager.execute(xml);
                if(callback != null) {
                    callback.response(response);
                }
            }
        });
    }

    public interface Callback{
        void response(String reponse);
    }
}
