package com.shizhefei.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.shizhefei.test.load.LoadViewHelper;
import com.shizhefei.view.loadview.R;

public class SimpleActivity extends Activity {

	private LoadViewHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);
		View contentLayout = findViewById(R.id.content_layout);
		helper = new LoadViewHelper(contentLayout);
	}

	public void showError(View view) {
		helper.showError("加载失败", "重试", new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "点击了重试", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void showEmpty(View view) {
		helper.showError("暂无数据", "重试", new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "点击了重试", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void showLoading(View view) {
		helper.showLoading("加载中...");
	}

	public void showSuccess(View view) {
		helper.restore();
	}
}
