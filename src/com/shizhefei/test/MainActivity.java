package com.shizhefei.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shizhefei.view.loadview.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showSimple(View view) {
		startActivity(new Intent(getApplicationContext(), SimpleActivity.class));
	}

	public void showExample1(View view) {
		startActivity(new Intent(getApplicationContext(), Example1Activity.class));
	}

	public void showExample2(View view) {
		startActivity(new Intent(getApplicationContext(), Example2Activity.class));
	}

}
