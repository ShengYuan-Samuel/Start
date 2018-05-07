package com.jiyun.start.ui.workview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.start.R;
import com.jiyun.start.model.entity.HomeWorkBean;
import com.jiyun.start.model.utils.TimeUtils;
import com.jiyun.start.view.GlideCircleTransform;

import java.util.List;
public class MyAdapter extends BaseAdapter {
    private List<HomeWorkBean.DataBean.ListBean> mList;
    private Context context;
    private final LayoutInflater inflater;
    private HomeWorkCallBack homeWorkCallBack;
    public MyAdapter(List<HomeWorkBean.DataBean.ListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public interface HomeWorkCallBack{
        void setDianZanCallBack(int position);
    }
    public void setHomeWorkCallBack(HomeWorkCallBack homeWorkCallBack){
        this.homeWorkCallBack = homeWorkCallBack;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.homework_view, null);
            holder.studentPhoto = convertView.findViewById(R.id.student_photo);
            holder.studentName = convertView.findViewById(R.id.student_name);
            holder.studentData = convertView.findViewById(R.id.student_data);
            holder.studentQiujiao  = convertView.findViewById(R.id.student_qiujiao);
            holder.studentContext = convertView.findViewById(R.id.student_context);
            holder.studentContentPhoto = convertView.findViewById(R.id.student_content_photo);
            holder.studentContextPhotoAction = convertView.findViewById(R.id.student_context_photo_action);
            holder.studentBiaoqian = convertView.findViewById(R.id.student_biaoqian);
            holder.teacherPhoto= convertView.findViewById(R.id.teacher_photo);
            holder.teacherName= convertView.findViewById(R.id.teacher_name);
            holder.teacherJibie= convertView.findViewById(R.id.teacher_jibie);
            holder.teacherZhuanye= convertView.findViewById(R.id.teacher_zhuanye);
            holder.teacherToukanMoney= convertView.findViewById(R.id.teacher_toukanMoney);
            holder.linearToukan= convertView.findViewById(R.id.linear_toukan);
            holder.teacherRelativeLayput= convertView.findViewById(R.id.teacher_relativeLayput);
            holder.cbMessage= convertView.findViewById(R.id.cb_message);
            holder.cbZan= convertView.findViewById(R.id.cb_zan);
            holder.linZan = convertView.findViewById(R.id.lin_zan);
            holder.cbShang= convertView.findViewById(R.id.cb_shang);
            holder.zhuangfa= convertView.findViewById(R.id.zhuangfa);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //这是学生头像
        if (mList.get(position).getPhoto() != null){
            Glide.with(context).load(mList.get(position).getPhoto()).bitmapTransform(new GlideCircleTransform(context)).crossFade(1000).into(holder.studentPhoto);
        }else{
            holder.studentPhoto.setImageResource(R.mipmap.user_head_portrait);
        }

        //这是设置学生姓名的
        holder.studentName.setText(mList.get(position).getNickname());
        //这是时间日月
        holder.studentData.setText(TimeUtils.getChatTime(mList.get(position).getCreateDate()));
        //这是设置来自哪里
        holder.studentQiujiao.setText(mList.get(position).getSource());
        //这是设置内容的
        holder.studentContext.setText(mList.get(position).getContent());
        //这是设置图片的
        if ("图片".equals(mList.get(position).getWorksType())){
            Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.studentContentPhoto);
            holder.studentContextPhotoAction.setVisibility(View.INVISIBLE);
        }else{
            Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.studentContentPhoto);
            holder.studentContextPhotoAction.setVisibility(View.VISIBLE);
        }
        //这是表演代表的数字
        holder.studentBiaoqian.setText(mList.get(position).getMajorIds());

        //这是判断是否指导老师
        if (mList.get(position).getTRealname() != null){
            holder.teacherRelativeLayput.setVisibility(View.VISIBLE);
            //这是老师头像
            if (mList.get(position).getTPhoto() != null){
                Glide.with(context).load(mList.get(position).getTPhoto()).bitmapTransform(new GlideCircleTransform(context)).crossFade(1000).into(holder.teacherPhoto);
            }else{
                holder.teacherPhoto.setImageResource(R.mipmap.user_head_portrait);
            }
            //这是设置老师的
            holder.teacherName.setText(mList.get(position).getTRealname());
            int tUserType = mList.get(position).getTUserType();
            if ( tUserType== 0){
                holder.teacherJibie.setImageResource(0);
            }else if ( tUserType == 2){
                holder.teacherJibie.setImageResource(R.mipmap.home_level_vip_blue);
            }else if(tUserType == 3){
                holder.teacherJibie.setImageResource(R.mipmap.home_level_vip_yellow);
            }else{
                holder.teacherJibie.setImageResource(R.mipmap.home_level_vip_red);
            }
            if(mList.get(position).getIsPeep()==0){
                holder.teacherToukanMoney.setText(String.format("%s元偷看",mList.get(position).getPeepPrice()));
            }else{
                holder.teacherToukanMoney.setText("查看");
            }
            holder.teacherZhuanye.setText(mList.get(position).getTIntro());

        }else{
            holder.teacherRelativeLayput.setVisibility(View.GONE);
        }


        if(mList.get(position).getCommentNum()!=0){
            holder.cbMessage.setText(mList.get(position).getCommentNum()+"");
        }else{
            holder.cbMessage.setText("");
        }

        if(mList.get(position).getPraiseNum()!=0){
            holder.cbZan.setText(mList.get(position).getPraiseNum()+"");
        }else{
            holder.cbZan.setText("");
        }
        if (mList.get(position).getGiftNum() != 0){
            holder.cbShang.setText(mList.get(position).getGiftNum()+"");
        }else{
            holder.cbShang.setText("");
        }

        //这是学生头像点击事件
        holder.studentPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyAdapter", "photo"+position);
            }
        });
        //这是老师头像的点击事件
        holder.teacherPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyAdapter", "teacher" + position);
            }
        });
        //这是一元点击的点击事件
        holder.linearToukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyAdapter", "toukan" + position);
            }
        });
        //这是信息的
        holder.cbMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               holder.cbMessage.setChecked(false);
                Log.d("MyAdapter", "你好" + position);

            }
        });
        //这是点赞的
        holder.cbZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.cbZan.isChecked()){
                    holder.cbZan.setChecked(true);
                    mList.get(position).setPraiseNum(mList.get(position).getPraiseNum()+1);
                    holder.cbZan.setText(mList.get(position).getPraiseNum()+"");
                }else{
                    holder.cbZan.setChecked(false);
                    if(mList.get(position).getPraiseNum()==0){
                        holder.cbZan.setText(mList.get(position).getPraiseNum()+"");
                    }else{
                        mList.get(position).setPraiseNum(mList.get(position).getPraiseNum()-1);
                        holder.cbZan.setText(mList.get(position).getPraiseNum()+"");
                    }
                }
                if(homeWorkCallBack!=null){
                    homeWorkCallBack.setDianZanCallBack(position);
                }
            }
        });
        //这是赏的点击事件
        holder.cbShang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cbShang.setChecked(true);
                Log.d("MyAdapter", "我是赏" + position);
            }
        });

        //这是转发的点击事件
        holder.zhuangfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyAdapter", "转发" + position);
            }
        });
        return convertView;
    }


    class ViewHolder {
        ImageView studentPhoto;
        TextView studentName;
        TextView studentData;
        TextView studentQiujiao;
        TextView studentContext;
        ImageView studentContentPhoto;
        ImageView studentContextPhotoAction;
        TextView studentBiaoqian;
        ImageView teacherPhoto;
        TextView teacherName;
        ImageView teacherJibie;
        TextView teacherZhuanye;
        TextView teacherToukanMoney;
        LinearLayout linearToukan;
        RelativeLayout teacherRelativeLayput;
        CheckBox cbMessage;
        CheckBox cbZan;
        LinearLayout linZan;
        CheckBox cbShang;
        ImageView zhuangfa;
    }
}
