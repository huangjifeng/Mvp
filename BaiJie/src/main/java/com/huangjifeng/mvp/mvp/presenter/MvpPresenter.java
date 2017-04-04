package com.huangjifeng.mvp.mvp.presenter;

import com.huangjifeng.mvp.mvp.view.MvpView;

/**
 * 中介
 * Created by Administrator on 2017/4/4.
 */

public interface MvpPresenter<V extends MvpView> {
    //绑定View
    public void attachView(V view);
    //解除绑定
    public void detachView();
}
