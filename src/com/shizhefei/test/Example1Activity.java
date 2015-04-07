package com.shizhefei.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shizhefei.test.load.LoadViewHelper;
import com.shizhefei.view.loadview.R;

public class Example1Activity extends Activity {

	private ListView listView;
	private LoadDataTask task;
	private LoadViewHelper helper;
	private ArrayAdapter<String> adapter;
	private List<String> data = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example1);
		listView =(ListView) findViewById(R.id.listView1);
		helper = new LoadViewHelper(listView);
		listView.setAdapter(adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
		task = new LoadDataTask(3);
		task.execute();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (task != null) {
			task.cancel(true);
		}
	}

	public void showLoadError(View view) {
		if (task != null) {
			task.cancel(true);
		}
		task = new LoadDataTask(1);
		task.execute();
	}

	public void showLoadEmpty(View view) {
		if (task != null) {
			task.cancel(true);
		}
		task = new LoadDataTask(2);
		task.execute();
	}

	public void showLoadSuccess(View view) {
		if (task != null) {
			task.cancel(true);
		}
		task = new LoadDataTask(3);
		task.execute();
	}

	private class LoadDataTask extends AsyncTask<Void, Void, List<String>> {
		private int type;

		public LoadDataTask(int type) {
			super();
			this.type = type;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			helper.showLoading("加载中...");
		}

		@Override
		protected List<String> doInBackground(Void... params) {
			try {
				// 模拟2秒到5秒的等待时间
				Thread.sleep((new Random().nextInt(30) + 20) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (type == 1) {
				return null;
			} else if (type == 2) {
				return new ArrayList<String>(0);
			}
			List<String> strings = new ArrayList<String>();
			for (int i = 0; i < 20; i++) {
				strings.add("数据" + i);
			}
			return strings;
		}

		@Override
		protected void onPostExecute(List<String> result) {
			super.onPostExecute(result);
			if (result == null) {
				helper.showError("加载失败", "重试", new OnClickListener() {

					@Override
					public void onClick(View v) {
						task = new LoadDataTask(1);
						task.execute();
					}
				});
			} else if (result.isEmpty()) {
				helper.showEmpty("暂无数据", "重试", new OnClickListener() {

					@Override
					public void onClick(View v) {
						task = new LoadDataTask(2);
						task.execute();
					}
				});
			} else {
				data.clear();
				data.addAll(result);
				helper.restore();
				adapter.notifyDataSetChanged();
			}
		}

	}
}
