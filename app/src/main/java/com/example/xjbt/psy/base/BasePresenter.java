package com.example.xjbt.psy.base;

import com.example.xjbt.psy.interfaces.IBaseModel;
import com.example.xjbt.psy.interfaces.IBasePresenter;
import com.example.xjbt.psy.interfaces.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    WeakReference<V> weakReference;
    protected V mView;

    IBaseModel model;
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unAttachView() {
        if(weakReference!=null){
            weakReference.clear();
        }
        if(mView!=null){
            mView=null;
        }
        if(model!=null){
            model.clear();//清除缓存
        }
    }
}
