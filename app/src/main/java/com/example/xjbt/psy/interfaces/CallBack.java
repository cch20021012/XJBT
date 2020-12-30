package com.example.xjbt.psy.interfaces;

public interface CallBack<T> {

    void success(T data);

    void fail(String err);

}
