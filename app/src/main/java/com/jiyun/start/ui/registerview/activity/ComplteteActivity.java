package com.jiyun.start.ui.registerview.activity;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseActivity;
import com.jiyun.start.contract.ComplteteContract;
import com.jiyun.start.presenter.CompletePresenter;
import com.jiyun.start.view.ClearEditText;
import com.jiyun.start.view.GlideCircleTransform;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplteteActivity extends BaseActivity<CompletePresenter> implements ComplteteContract.View {


    @BindView(R.id.compltete_return)
    ImageView complteteReturn;
    @BindView(R.id.tv_tiaoguo)
    TextView tvTiaoguo;
    @BindView(R.id.image_camera)
    ImageView imageCamera;
    @BindView(R.id.reg_userName)
    ClearEditText regUserName;
    @BindView(R.id.complete_man)
    CheckBox completeMan;
    @BindView(R.id.complete_woman)
    CheckBox completeWoman;
    @BindView(R.id.reg_userpsw)
    ClearEditText regUserpsw;
    @BindView(R.id.compltete_okBtu)
    Button complteteOkBtu;
    @BindView(R.id.image_photo)
    ImageView imagePhoto;
    private int sex = 0;
    private Uri contentUri;
    private String phone;
    private Uri mUri;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_compltete;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
       // Log.d("ComplteteActivity", phone);
    }

    @Override
    protected void loadData() {

    }



    @OnClick({R.id.compltete_return, R.id.tv_tiaoguo, R.id.image_camera, R.id.complete_man, R.id.complete_woman, R.id.compltete_okBtu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.compltete_return:
                finish();
                break;
            case R.id.tv_tiaoguo:
               // presenter.upCompleteuser(regUserName.getText().toString().trim(),"",phone,regUserpsw.getText().toString().trim(),sex);

                break;
            case R.id.image_camera:
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 2);
                //startCamera();
                break;
            case R.id.complete_man:
                completeMan.setChecked(true);
                completeWoman.setChecked(false);
                sex = 0;


                break;
            case R.id.complete_woman:
                completeWoman.setChecked(true);
                completeMan.setChecked(false);
                sex = 1;

                break;
            case R.id.compltete_okBtu:
                presenter.upCompleteuser(regUserName.getText().toString().trim(),"",phone,regUserpsw.getText().toString().trim(),sex);
                break;
        }
    }

    /**
     * 打开相机获取图片
     */
    private void startCamera() {
        File imagePath = new File(Environment.getExternalStorageDirectory(), "images");
        if (!imagePath.exists()) imagePath.mkdirs();
        File newFile = new File(imagePath, "default_image.jpg");

        //第二参数是在manifest.xml定义 provider的authorities属性
        contentUri = FileProvider.getUriForFile(this, "com.jiyun.start.fileprovider", newFile);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //兼容版本处理，因为 intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION) 只在5.0以上的版本有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ClipData clip =
                    ClipData.newUri(getContentResolver(), "A photo", contentUri);
            intent.setClipData(clip);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            List<ResolveInfo> resInfoList =
                    getPackageManager()
                            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                grantUriPermission(packageName, contentUri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        //startActivityForResult(intent, 1000);
        startActivityForResult(intent,1);
    }

    //处理回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK) {
                    ContentResolver contentProvider = getContentResolver();
                    ParcelFileDescriptor mInputPFD;
                    try {
                        //获取contentProvider图片
                        mInputPFD = contentProvider.openFileDescriptor(contentUri, "r");
                        FileDescriptor fileDescriptor = mInputPFD.getFileDescriptor();
                        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        imagePhoto.setImageBitmap(bitmap);
                        File file = savaBitmap(bitmap);
                        //   presenter.uploadImg(file);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    // 裁剪图片
                    mUri = data.getData();
                    cropPhoto(mUri);
                }
                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    Bitmap head = extras.getParcelable("data");
                    if (head != null) {
                        imagePhoto.setImageBitmap(head);
                        // 用ImageView显示出来
                        //上传到服务器,上传成功后可以删除掉本地的临时头像文件
                        File file = savaBitmap(head);

                    }
                }
                break;

        }

    }


    @Override
    public void showUpLoadImgData(String str) {
        Log.d("ComplteteActivity222", str);

    }

    @Override
    public void shoeCompleteUserData(String data) {
        Log.d("ComplteteActivity", data);

    }

    //这是获取文件的地址
    private File savaBitmap(Bitmap bitmap){
        String  path= Environment.getExternalStorageDirectory() + "/startImage";
        FileOutputStream b = null;
        String filename="";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        filename = path +File.separator+android.text.format.DateFormat
                .format("yyyyMMddkkmmss",
                        new Date()).toString()+".jpg";
        File file1 = new File(path, filename);
        try {
            b = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件

            //presenter.uploadImg(file1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return file1;
    }
    //这是修改图片大小的
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
}