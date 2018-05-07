package com.jiyun.start.ui.workview.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseFragment;
import com.jiyun.start.contract.HomeWorkContract;
import com.jiyun.start.model.entity.HomeWorkBean;
import com.jiyun.start.model.entity.TokenBean;
import com.jiyun.start.model.utils.SavaShareUtils;
import com.jiyun.start.presenter.HomeWorkPresenter;
import com.jiyun.start.ui.HomeActivity;
import com.jiyun.start.ui.workview.adapter.MyAdapter;
import com.jiyun.start.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WorkFragment extends BaseFragment<HomeWorkPresenter> implements HomeWorkContract.View, MyAdapter.HomeWorkCallBack {


    @BindView(R.id.commit_work_image)
    ImageView commitWorkImage;
    @BindView(R.id.commit_work_tv)
    TextView commitWorkTv;
    @BindView(R.id.submit_work_image)
    ImageView submitWorkImage;
    @BindView(R.id.submit_work_tv)
    TextView submitWorkTv;
    @BindView(R.id.capacity_tv)
    TextView capacityTv;
    @BindView(R.id.capacity_tv_line)
    TextView capacityTvLine;
    @BindView(R.id.eavesdrop_tv)
    TextView eavesdropTv;
    @BindView(R.id.eavesdrop_tv_line)
    TextView eavesdropTvLine;
    @BindView(R.id.comment_tv)
    TextView commentTv;
    @BindView(R.id.comment_line)
    TextView commentLine;
    @BindView(R.id.home_work_fragment_comment_group)
    RelativeLayout homeWorkFragmentCommentGroup;
    @BindView(R.id.homework_list)
    MyListView homeworkList;
    @BindView(R.id.homework_layout)
    RelativeLayout homeworkLayout;
    private List<HomeWorkBean.DataBean.ListBean> mList;
    private MyAdapter myAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void init() {
        mList = new ArrayList<>();
        myAdapter = new MyAdapter(mList, getContext());
        myAdapter.setHomeWorkCallBack(this);
        homeworkList.setAdapter(myAdapter);
        homeworkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("WorkFragment", "llll");
            }
        });

    }

    @Override
    protected void loadData() {
        presenter.getToken();

    }

    @Override
    public void updateTitle() {
        ((HomeActivity) (App.context)).getTitleBar().setVisibility(View.VISIBLE);
        ((HomeActivity) (App.context)).getImageShape().setVisibility(View.VISIBLE);
        ((HomeActivity) (App.context)).getImageValuable().setVisibility(View.INVISIBLE);
        ((HomeActivity) (App.context)).getTitleLogo().setVisibility(View.VISIBLE);
    }

    @Override
    public void showToken(TokenBean tokenBean) {
        Log.d("WorkFragment", tokenBean.getData().getApptoken());
        String token = SavaShareUtils.getInstance().getToken();
        Log.d("WorkFragmentToken", token);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getHomeWorkData("0","1","0");
        capacityTvLine.setVisibility(View.VISIBLE);
        eavesdropTvLine.setVisibility(View.GONE);
        commentLine.setVisibility(View.GONE);
    }

    @Override
    public void showHomeWorkData(HomeWorkBean data) {
      mList.clear();
      if (data.getCode() == 0){
          homeworkList.setVisibility(View.VISIBLE);
          homeworkLayout.setVisibility(View.GONE);
          List<HomeWorkBean.DataBean.ListBean> list = data.getData().getList();
          mList.addAll(list);
          myAdapter.notifyDataSetChanged();
      }else{
          homeworkList.setVisibility(View.GONE);
          homeworkLayout.setVisibility(View.VISIBLE);
      }


    }

    @OnClick({R.id.commit_work_image, R.id.submit_work_image, R.id.capacity_tv, R.id.eavesdrop_tv, R.id.comment_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.commit_work_image:
                break;
            case R.id.submit_work_image:
                break;
            case R.id.capacity_tv:
                presenter.getHomeWorkData("0","1","0");
                 capacityTvLine.setVisibility(View.VISIBLE);
                eavesdropTvLine.setVisibility(View.GONE);
                commentLine.setVisibility(View.GONE);

                break;
            case R.id.eavesdrop_tv:
                presenter.getHomeWorkData("0","1","1");
                eavesdropTvLine.setVisibility(View.VISIBLE);
                capacityTvLine.setVisibility(View.GONE);
                commentLine.setVisibility(View.GONE);

                break;
            case R.id.comment_tv:
                presenter.getHomeWorkData("0","1","2");
                commentLine.setVisibility(View.VISIBLE);
                eavesdropTvLine.setVisibility(View.GONE);
                capacityTvLine.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void setDianZanCallBack(int position) {
        Log.d("WorkFragment", "mList.get(position).getPraiseNum():" + mList.get(position).getPraiseNum());
    }
}
