package com.louiewh.keeprunning.mvp;

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


    protected abstract @LayoutRes int getContentView();


    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initListeners();

    protected abstract void initData();

    protected abstract void bind();


    @Override
    protected void onStop() {
//        unbinder.unbind();
        super.onStop();
    }
}
