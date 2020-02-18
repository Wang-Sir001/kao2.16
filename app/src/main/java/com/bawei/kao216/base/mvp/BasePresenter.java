package com.bawei.kao216.base.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract M initModel();

    public V getView(){
        return weakReference.get();
    }
}
