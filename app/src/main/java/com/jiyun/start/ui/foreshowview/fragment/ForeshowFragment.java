package com.jiyun.start.ui.foreshowview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseFragment;
import com.jiyun.start.ui.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForeshowFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_foreshow;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void updateTitle() {
        ((HomeActivity)(App.context)).getTitleBar().setVisibility(View.VISIBLE);
        ((HomeActivity)(App.context)).getImageShape().setVisibility(View.VISIBLE);
        ((HomeActivity)(App.context)).getImageValuable().setVisibility(View.INVISIBLE);
        ((HomeActivity)(App.context)).getTitleLogo().setVisibility(View.VISIBLE);

    }
}
