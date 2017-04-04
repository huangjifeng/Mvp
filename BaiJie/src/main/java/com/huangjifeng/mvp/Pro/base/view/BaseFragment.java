package com.huangjifeng.mvp.Pro.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangjifeng.mvp.mvp.presenter.impl.BaseMvpPreseter;
import com.huangjifeng.mvp.mvp.view.impl.MvpFragment;

/**
 * Created by Administrator on 2017/4/4.
 */

public abstract class BaseFragment<P extends BaseMvpPreseter> extends MvpFragment<P> {
    //我们自己的Fragment需要缓存视图
    private View viewContent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewContent == null) {
            viewContent = inflater.inflate(getContentView(), container, false);
            initContentView(viewContent);
        }
        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null) {
            //如果存在，那么我就干掉，重新添加，这样的方式我们就可以缓存视图
            parent.removeView(viewContent);
        }

        return viewContent;
    }

    public abstract int getContentView();

    public abstract void initContentView(View viewContent);

    @Override
    public P bindPresenter() {
        return null;
    }
}
