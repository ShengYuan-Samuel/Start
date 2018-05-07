package com.jiyun.start.ui.loginview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.ForgetPswContract;
import com.jiyun.start.presenter.ForgetPswPresenter;
import com.jiyun.start.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPswActivity extends BaseActivity<ForgetPswPresenter> implements ForgetPswContract.View{


    @BindView(R.id.forget_return)
    ImageView forgetReturn;
    @BindView(R.id.forget_phone)
    ClearEditText forgetPhone;
    @BindView(R.id.forget_phoneCode)
    ClearEditText forgetPhoneCode;
    @BindView(R.id.get_forgetCode)
    TextView getForgetCode;
    @BindView(R.id.forget_forgetbtn)
    Button forgetForgetbtn;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_forget_psw;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.forget_return, R.id.get_forgetCode, R.id.forget_forgetbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_return:
                break;
            case R.id.get_forgetCode:
            presenter.getForgetPswCode(forgetPhone.getText().toString().trim());
                break;
            case R.id.forget_forgetbtn:
            presenter.getForgetUser(forgetPhone.getText().toString().trim(),forgetPhoneCode.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showForgetPhoneCode(String data) {
        Log.d("ForgetPswActivity", data);

    }

    @Override
    public void shoeForgetPhone(String data) {
        Log.d("ForgetPswActivity11111", data);
        if (data != null){
            Intent intent = new Intent(ForgetPswActivity.this, ResetActivity.class);
            intent.putExtra("phone",forgetPhone.getText().toString().trim());
            startActivity(intent);
        }
    }
}
