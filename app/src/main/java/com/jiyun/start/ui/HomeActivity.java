package com.jiyun.start.ui;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.ui.baodianview.fragment.BaoDianFragment;
import com.jiyun.start.ui.foreshowview.fragment.ForeshowFragment;
import com.jiyun.start.ui.myview.fragment.MyFragment;
import com.jiyun.start.ui.topteacherview.fragment.TopTeacherFragment;
import com.jiyun.start.ui.workview.fragment.WorkFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.title_logo)
    ImageView titleLogo;
    @BindView(R.id.image_shape)
    ImageView imageShape;
    @BindView(R.id.image_valuable)
    ImageView imageValuable;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.homeBtn)
    RadioButton homeBtn;
    @BindView(R.id.workBtn)
    RadioButton workBtn;
    @BindView(R.id.baodianBtn)
    RadioButton baodianBtn;
    @BindView(R.id.foreshowBtn)
    RadioButton foreshowBtn;
    @BindView(R.id.myBtn)
    RadioButton myBtn;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        getPression();
        setContentView(TopTeacherFragment.class).updateTitle();

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.image_shape, R.id.image_valuable, R.id.homeBtn, R.id.workBtn, R.id.baodianBtn, R.id.foreshowBtn, R.id.myBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_shape:
                break;
            case R.id.image_valuable:
                break;
            case R.id.homeBtn:
                setContentView(TopTeacherFragment.class).updateTitle();
                break;
            case R.id.workBtn:
                setContentView(WorkFragment.class).updateTitle();
                break;
            case R.id.baodianBtn:
                setContentView(BaoDianFragment.class).updateTitle();
                break;
            case R.id.foreshowBtn:
                setContentView(ForeshowFragment.class).updateTitle();
                break;
            case R.id.myBtn:
                setContentView(MyFragment.class).updateTitle();
                break;
        }
    }

    public ImageView getTitleLogo() {
        return titleLogo;
    }
    public ImageView getImageShape() {
        return imageShape;
    }
    public ImageView getImageValuable() {
        return imageValuable;
    }

    public RelativeLayout getTitleBar() {
        return titleBar;
    }

    private void getPression(){
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS,
            Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

}
