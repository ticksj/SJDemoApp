package com.sj.a_6_important_moudle.handler;

import androidx.annotation.NonNull;

/**
 * Created by SJ on 2020/2/10.
 */
public class CustomMessage {
    public CustomHandler target;
    Object object;
    public CustomMessage() {
    }
    public void setObject(Object object) {
        this.object = object;
    }
    @NonNull
    @Override
    public String toString() {
        return object.toString();
    }
}
