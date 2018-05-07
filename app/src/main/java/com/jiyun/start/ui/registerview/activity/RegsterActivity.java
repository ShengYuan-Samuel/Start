package com.jiyun.start.ui.registerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.ReigsterContract;
import com.jiyun.start.model.entity.RegistUserBean;
import com.jiyun.start.presenter.ReigsterPresenter;
import com.jiyun.start.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegsterActivity extends BaseActivity<ReigsterPresenter> implements ReigsterContract.View {


    @BindView(R.id.register_return)
    ImageView registerReturn;
    @BindView(R.id.tv_kuaisu)
    TextView tvKuaisu;
    @BindView(R.id.regsiter_phone)
    ClearEditText regsiterPhone;
    @BindView(R.id.register_phoneCode)
    ClearEditText registerPhoneCode;
    @BindView(R.id.get_registerCode)
    TextView getRegisterCode;
    @BindView(R.id.lin_layout1)
    LinearLayout linLayout1;
    @BindView(R.id.regsiter_fuwuxieyi)
    TextView regsiterFuwuxieyi;
    @BindView(R.id.lin_layout2)
    LinearLayout linLayout2;
    @BindView(R.id.register_registerbtn)
    Button registerRegisterbtn;
    @BindView(R.id.weixin_image)
    ImageView weixinImage;
    @BindView(R.id.qq_image)
    ImageView qqImage;
    @BindView(R.id.weibo_image)
    ImageView weiboImage;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_regster;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.register_return, R.id.get_registerCode, R.id.register_registerbtn, R.id.weixin_image, R.id.qq_image, R.id.weibo_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_return:
                finish();
                break;
            case R.id.get_registerCode:
                presenter.getReigsterCode(regsiterPhone.getText().toString().trim());
                break;
            case R.id.register_registerbtn:
                presenter.getReigsterData(regsiterPhone.getText().toString().trim(),registerPhoneCode.getText().toString().trim());
                break;
            case R.id.weixin_image:
                break;
            case R.id.qq_image:
                break;
            case R.id.weibo_image:
                break;
        }
    }

    @Override
    public void showReigsterCode(String data) {
        Log.d("2RegsterActivity", data);
    }

    @Override
    public void showReigsterData(RegistUserBean data) {
        int code = data.getCode();
        if (code == 0){
            Intent intent = new Intent(this, ComplteteActivity.class);
            intent.putExtra("phone",regsiterPhone.getText().toString().trim());
            startActivity(intent);
        }else{
            Toast.makeText(this, "手机号或者验证码不正确", Toast.LENGTH_SHORT).show();
        }






    }
}
