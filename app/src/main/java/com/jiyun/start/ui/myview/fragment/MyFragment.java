package com.jiyun.start.ui.myview.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.base.BaseFragment;
import com.jiyun.start.contract.MyUserInFoContract;
import com.jiyun.start.model.entity.LoginUserOkBean;
import com.jiyun.start.model.utils.SavaShareUtils;
import com.jiyun.start.presenter.MyInfoPresenter;
import com.jiyun.start.ui.HomeActivity;
import com.jiyun.start.ui.loginview.activity.LoginActivity;
import com.jiyun.start.ui.myview.activity.InFoActivity;
import com.jiyun.start.ui.registerview.activity.RegsterActivity;
import com.jiyun.start.view.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends BaseFragment<MyInfoPresenter> implements MyUserInFoContract.View {

    @BindView(R.id.tv_renzheng)
    TextView tvRenZheng;
    @BindView(R.id.home_my_message)
    ImageView homeMyMessage;
    @BindView(R.id.home_my)
    RelativeLayout homeMy;
    @BindView(R.id.home_my_seeting)
    ImageView homeMySeeting;
    @BindView(R.id.user_image)
    ImageView userImage;
    @BindView(R.id.noLogin_layout)
    RelativeLayout noLoginLayout;
    @BindView(R.id.userlogin_image)
    ImageView userloginImage;
    @BindView(R.id.userlogin_name)
    TextView userloginName;
    @BindView(R.id.loginInfo_layout)
    LinearLayout loginInfoLayout;
    @BindView(R.id.yseLogin_layout)
    LinearLayout yseLoginLayout;
    @BindView(R.id.home_my_register)
    Button homeMyRegister;
    @BindView(R.id.home_my_login)
    Button homeMyLogin;
    @BindView(R.id.nologinbuttom_layout)
    LinearLayout nologinbuttomLayout;
    @BindView(R.id.tv_zuopin)
    TextView tvZuopin;
    @BindView(R.id.login_zuopinlayout)
    LinearLayout loginZuopinlayout;
    @BindView(R.id.tv_tiezi)
    TextView tvTiezi;
    @BindView(R.id.login_tilezilayout)
    LinearLayout loginTilezilayout;
    @BindView(R.id.tv_guanzhu)
    TextView tvGuanzhu;
    @BindView(R.id.login_guanzhulayout)
    LinearLayout loginGuanzhulayout;
    @BindView(R.id.tv_fensi)
    TextView tvFensi;
    @BindView(R.id.login_fensilayout)
    LinearLayout loginFensilayout;
    @BindView(R.id.login_daifukuanlayout)
    LinearLayout loginDaifukuanlayout;
    @BindView(R.id.login_daishiyonglayout)
    LinearLayout loginDaishiyonglayout;
    @BindView(R.id.login_daituihuolayout)
    LinearLayout loginDaituihuolayout;
    @BindView(R.id.login_wodedingdan)
    LinearLayout loginWodedingdan;
    @BindView(R.id.fragment_my_recharge_content)
    TextView fragmentMyRechargeContent;
    @BindView(R.id.login_liwulayout)
    RelativeLayout loginLiwulayout;
    @BindView(R.id.login_shoucanglayout)
    RelativeLayout loginShoucanglayout;
    @BindView(R.id.login_wodepianhaolayout)
    RelativeLayout loginWodepianhaolayout;
    @BindView(R.id.login_woyaorenzhenglayout)
    RelativeLayout loginWoyaorenzhenglayout;
    @BindView(R.id.login_chongzhilayout)
    LinearLayout loginChongzhilayout;
    @BindView(R.id.loginButtom_layout)
    LinearLayout loginButtomLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void onResume() {
        super.onResume();
        int userId = SavaShareUtils.getInstance().getUserId();
        if (userId == 0) {
            noLoginLayout.setVisibility(View.VISIBLE);
            nologinbuttomLayout.setVisibility(View.VISIBLE);
            yseLoginLayout.setVisibility(View.GONE);
            loginButtomLayout.setVisibility(View.GONE);

        }else{
            presenter.getUsetInfoData(SavaShareUtils.getInstance().getUserId());
            yseLoginLayout.setVisibility(View.VISIBLE);
            loginButtomLayout.setVisibility(View.VISIBLE);
            noLoginLayout.setVisibility(View.GONE);
            nologinbuttomLayout.setVisibility(View.GONE);
        }
    }

    @Override
    protected void init() {


    }

    @Override
    protected void loadData() {

    }

    @Override
    public void updateTitle() {
        ((HomeActivity)(App.context)).getTitleBar().setVisibility(View.GONE);
    }

    @OnClick({R.id.home_my_message, R.id.home_my_seeting, R.id.loginInfo_layout, R.id.home_my_register, R.id.home_my_login, R.id.login_zuopinlayout, R.id.login_tilezilayout, R.id.login_guanzhulayout, R.id.login_fensilayout, R.id.login_daifukuanlayout, R.id.login_daishiyonglayout, R.id.login_daituihuolayout, R.id.login_wodedingdan, R.id.login_liwulayout, R.id.login_shoucanglayout, R.id.login_wodepianhaolayout, R.id.login_woyaorenzhenglayout, R.id.login_chongzhilayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_my_message:
                Log.d("MyFragment", "点击了");
                SavaShareUtils.getInstance().clearId();
                break;
            case R.id.home_my_seeting:
                break;
            case R.id.loginInfo_layout:
                startActivity(new Intent(getContext(), InFoActivity.class));
                break;
            case R.id.home_my_register:
                startActivity(new Intent(getContext(), RegsterActivity.class));
                break;
            case R.id.home_my_login:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.login_zuopinlayout:
                break;
            case R.id.login_tilezilayout:
                break;
            case R.id.login_guanzhulayout:
                break;
            case R.id.login_fensilayout:
                break;
            case R.id.login_daifukuanlayout:
                break;
            case R.id.login_daishiyonglayout:
                break;
            case R.id.login_daituihuolayout:
                break;
            case R.id.login_wodedingdan:
                break;
            case R.id.login_liwulayout:
                break;
            case R.id.login_shoucanglayout:
                break;
            case R.id.login_wodepianhaolayout:
                break;
            case R.id.login_woyaorenzhenglayout:
                break;
            case R.id.login_chongzhilayout:
                break;
        }
    }

    @Override
    public void showUserData(LoginUserOkBean userInfo) {
        LoginUserOkBean.DataBean data = userInfo.getData();
        if (data.getUserType() == 1){
            tvZuopin.setText(data.getCoachingCount()+"");
            tvTiezi.setText(data.getArtcircleCount()+"");
            tvGuanzhu.setText(data.getAttentionCount()+"");
            tvFensi.setText(data.getFansCount()+"");
            if (data.getPhoto() != null){
                Glide.with(getContext()).load(data.getPhoto()).bitmapTransform(new GlideCircleTransform(getContext())).crossFade(1000).into(userloginImage);
            }else{
                userloginImage.setImageResource(R.mipmap.user_head_portrait);
            }
            if(data.getIsAuth()==-1){
                tvRenZheng.setText("未认证");
                userloginName.setText(data.getNickname());
            }
            else if(data.getIsAuth()==0){
                tvRenZheng.setText("待审核");
                userloginName.setText(data.getNickname());
            }else if(data.getIsAuth()==1){
                tvRenZheng.setText("已认证");
                userloginName.setText(data.getNickname());
            }else if(data.getIsAuth()==2){
                tvRenZheng.setText("未通过");
                userloginName.setText(data.getNickname());
            }

        }



    }
}
