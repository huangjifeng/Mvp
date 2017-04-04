package com.huangjifeng.mvp.mvp.view.impl;

import com.huangjifeng.mvp.mvp.view.MvpView;

/**
 * 请求数据，并且监听刷新UI界面(标准)----说白了就是经常看到的loading页
 * Created by Administrator on 2017/4/4.
 */

public interface MvpLceView<M> extends MvpView {
    //显示加载中的视图（说白了就是监听加载类型，下拉刷新或者上拉刷新）
    public void showLoading(boolean pullToRefresh);

    //显示ContentView
    public void showContent();

    //加载错误
    public void showError(Exception e,boolean pullToRefresh);

    //绑定数据
    public void showData(M data);
}
