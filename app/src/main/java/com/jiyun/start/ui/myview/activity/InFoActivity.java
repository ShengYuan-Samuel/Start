package com.jiyun.start.ui.myview.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.RelativeLayout;

import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.InFoUserContract;
import com.jiyun.start.presenter.InFoUserPresenter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class InFoActivity extends BaseActivity<InFoUserPresenter> implements InFoUserContract.View{


    @BindView(R.id.infophoto)
    RelativeLayout infophoto;
    private File image_file;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_in_fo;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }



    @OnClick(R.id.infophoto)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (data == null){
                return;
            }
            switch (requestCode){

                case 1:
                    startPhotoZoom(data.getData());
                    break;
                case 2:
                    if(image_file==null){
                        return ;
                    }
                  //  presenter.uploadImg(image_file);
                    break;
            }
        }
    }
    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", 160);
        intent.putExtra("outputY", 160);
        intent.putExtra("return-data", true);
        image_file = getPhotoFileName();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image_file));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, 2);
    }
    private File getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return new File(Environment.getExternalStorageDirectory()+File.separator+dateFormat.format(date) + ".jpg");
    }

    @Override
    public void showUpLoadImgData(String data) {

    }
}
