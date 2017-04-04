package com.huangjifeng.mvp.mvp.view.impl;

/**
 * Created by Administrator on 2017/4/4.
 */

public abstract class BaseMvpLceView<M> implements MvpLceView<M> {
    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}
