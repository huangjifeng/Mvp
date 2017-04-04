package com.huangjifeng.mvp.mvp.presenter.impl;

import com.huangjifeng.mvp.mvp.presenter.MvpPresenter;
import com.huangjifeng.mvp.mvp.view.MvpView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Administrator on 2017/4/4.
 */

public class BaseMvpPreseter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }
}
