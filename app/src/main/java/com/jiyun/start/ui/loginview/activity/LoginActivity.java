package com.jiyun.start.ui.loginview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.LoginContract;
import com.jiyun.start.model.entity.LoginUserBean;
import com.jiyun.start.model.utils.SavaShareUtils;
import com.jiyun.start.presenter.LoginPresenter;
import com.jiyun.start.ui.myview.fragment.MyFragment;
import com.jiyun.start.ui.registerview.activity.RegsterActivity;
import com.jiyun.start.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_close)
    TextView loginClose;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_phone)
    ClearEditText loginPhone;
    @BindView(R.id.login_psw)
    ClearEditText loginPsw;
    @BindView(R.id.forget_psw)
    TextView forgetPsw;
    @BindView(R.id.login_btu)
    Button loginBtu;
    @BindView(R.id.login_weixin_image)
    ImageView loginWeixinImage;
    @BindView(R.id.login_qq_image)
    ImageView loginQqImage;
    @BindView(R.id.login_weibo_image)
    ImageView loginWeiboImage;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showLoginData(LoginUserBean data) {

        int code = data.getCode();
        String message = data.getMessage();
        Log.d("LoginActivity", "code:" + code);
        LoginUserBean.DataBean data1 = data.getData();
        if (! "密码错误" .equals(message)){
            SavaShareUtils.getInstance().setUserToken(data1.getToken());
            SavaShareUtils.getInstance().setUserId(data1.getId());
           // startActivity(new Intent(LoginActivity.this, MyFragment.class));
            finish();
        }else{
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
        }



    }



    @OnClick({R.id.login_close, R.id.login_register, R.id.login_btu, R.id.login_weixin_image, R.id.login_qq_image, R.id.login_weibo_image,R.id.forget_psw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_close:
                finish();
                break;
            case R.id.login_register:
                startActivity(new Intent(this, RegsterActivity.class));
                finish();
                break;
            case R.id.login_btu:
                presenter.getLoginData(loginPhone.getText().toString().trim(),loginPsw.getText().toString().trim());
                break;
            case R.id.login_weixin_image:
                break;
            case R.id.login_qq_image:
                break;
            case R.id.login_weibo_image:
                break;
            case R.id.forget_psw:
                startActivity(new Intent(this,ForgetPswActivity.class));
                break;
        }
    }
}
