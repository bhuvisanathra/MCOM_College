package com.example.wallpaperp;

import android.Manifest;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FullImageActivity extends AppCompatActivity {

    private ImageView fullimage;
    private Button apply,downloadImg;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        fullimage=findViewById(R.id.fullImage);
        apply=findViewById(R.id.apply);
        downloadImg=findViewById(R.id.download_img);

        url = getIntent().getStringExtra("image");
        Glide.with(this).load(url).into(fullimage);

        PRDownloader.initialize(getApplicationContext());


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackground();
            }

        });
        downloadImg.setOnClickListener(v ->{
            checkPermission();
        });
    }

    private void checkPermission() {
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                if(report.areAllPermissionsGranted()){
                    downloadImage();
                }else{
                    Toast.makeText(FullImageActivity.this, "Please Allow Permission", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

            }
        }).check();
    }

    private void downloadImage() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Downloading");
        pd.setCancelable(false);
        pd.show();
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        PRDownloader.download(url, file.getPath(), URLUtil.guessFileName(url,null,null))
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })
                .setOnPauseListener(new OnPauseListener() {
                    @Override
                    public void onPause() {

                    }
                })
                .setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel() {

                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                            long per = progress.currentBytes*100/progress.totalBytes;
                            pd.setMessage("Downloading :"+per+"%");
                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        pd.dismiss();
                        Toast.makeText(FullImageActivity.this, "Download Done", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Error error) {
                        pd.dismiss();
                        Toast.makeText(FullImageActivity.this, "Download Not Done", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share_option,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==(R.id.share)) {
            BitmapDrawable drawable = (BitmapDrawable) fullimage.getDrawable();
            Bitmap bitmap = drawable.getBitmap();

            String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
            Uri uri = Uri.parse(bitmapPath);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("images/png");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.putExtra(Intent.EXTRA_TEXT, "Play Store Link");
            startActivity(Intent.createChooser(intent, "Share"));
        }
        return super.onOptionsItemSelected(item);
    }

    private void setBackground() {
        Bitmap  bitmap= ((BitmapDrawable)fullimage.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try {
            Toast.makeText(this, "Set SuccessFull", Toast.LENGTH_SHORT).show();
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(this, "Error"+ e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}