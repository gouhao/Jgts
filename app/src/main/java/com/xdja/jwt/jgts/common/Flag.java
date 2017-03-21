package com.xdja.jwt.jgts.common;

/**
 * Created by gouhao on 3/21/2017.
 */

public class Flag {
    private int flag = 0;

    public void set(boolean value, int index) {
        if(value) {
            flag |= 1 << index;
        } else {
            flag &= ~(1 << index);
        }
    }

    public boolean get(int index) {
        return (flag >> index & 1) == 1;
    }
}
