package com.louiewh.keeprunning.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

abstract public class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        unbinder = ButterKnife.bind(this);

        initView(savedInstanceState);
        initListeners();
        initData();
    }

    protected abstract void initData();


    /**
     * --次序1--
     * 返回layout的id
     */
    public abstract @LayoutRes int getContentView();

    /**
     * --次序2--
     * 初始化view
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 设置监听器，在initView()之后
     * --次序3--
     */
    public abstract void initListeners();

    /**
     * --次序4--
     * 绑定
     */
    public abstract void bind();



    @Override
    protected void onStop() {
//        unbinder.unbind();
        super.onStop();
    }
}
