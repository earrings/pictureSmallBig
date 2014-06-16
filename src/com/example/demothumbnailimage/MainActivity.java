package com.example.demothumbnailimage;

import java.io.InputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onThumbnailClick(View v) {
//		final AlertDialog dialog = new AlertDialog.Builder(this).create();
//		ImageView imgView = getView();
//		dialog.setView(imgView);
//		dialog.show();

		// 全屏显示的方法
		 final Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		 ImageView imgView = getView();
		 dialog.setContentView(imgView);
		 dialog.show();

		// 点击图片消失
		imgView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
	}

	private ImageView getView() {
		ImageView imgView = new ImageView(this);
		imgView.setLayoutParams(new LayoutParams(500, 600));

		InputStream is = getResources().openRawResource(R.drawable.pic);
		Drawable drawable = BitmapDrawable.createFromStream(is, null);
		imgView.setImageDrawable(drawable);

		return imgView;
	}
}
