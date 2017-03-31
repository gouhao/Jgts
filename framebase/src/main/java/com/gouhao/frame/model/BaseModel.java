package com.gouhao.frame.model;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class BaseModel implements IModel {
    protected String TAG = getClass().getSimpleName();

    public interface Callback<T extends Object>{
        void executeFinish(T result);
    }
}
