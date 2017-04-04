package com.huangjifeng.mvp.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.huangjifeng.mvp.mvp.presenter.impl.BaseMvpPreseter;
import com.huangjifeng.mvp.mvp.view.MvpView;

/**
 * 将我们的MVP架构集成到我们的Activity
 * MvpActivity --- 是MVP框架的
 * Created by Administrator on 2017/4/4.
 */

public abstract class MvpActivity<P extends BaseMvpPreseter> extends AppCompatActivity implements MvpView {

    //MVP架构P是动态的，不能写死
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        //我的presenter中介我是不是管理view --- 关联
        if (presenter != null){
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁的时候 --- 解除绑定
        if (presenter != null){
            presenter.detachView();
        }
    }

    public abstract P bindPresenter();


}
