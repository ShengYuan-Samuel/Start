package com.jiyun.start.ui.loginview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.ResetPswContract;
import com.jiyun.start.presenter.ResetPswPresenter;
import com.jiyun.start.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetActivity extends BaseActivity<ResetPswPresenter> implements ResetPswContract.View {


    @BindView(R.id.reset_return)
    ImageView resetReturn;
    @BindView(R.id.reset_psw)
    ClearEditText resetPsw;
    @BindView(R.id.reset_psw_ok)
    ClearEditText resetPswOk;
    @BindView(R.id.resetBtu)
    Button resetBtu;
    private String phone;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_reset;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");


    }

    @Override
    protected void loadData() {

    }



    @OnClick({R.id.reset_return, R.id.resetBtu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reset_return:
                finish();
                break;
            case R.id.resetBtu:
                presenter.resetPassword(phone,resetPswOk.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showResetPassWord(String data) {
        Log.d("ResetActivity", data);

    }
}
