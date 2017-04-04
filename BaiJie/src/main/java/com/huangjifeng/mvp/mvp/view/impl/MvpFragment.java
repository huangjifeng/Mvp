package com.huangjifeng.mvp.mvp.view.impl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.huangjifeng.mvp.mvp.presenter.impl.BaseMvpPreseter;
import com.huangjifeng.mvp.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/4/4.
 */

public abstract class MvpFragment<P extends BaseMvpPreseter> extends Fragment implements MvpView {
    protected P presenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = bindPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    //绑定
    public abstract P bindPresenter();
}
