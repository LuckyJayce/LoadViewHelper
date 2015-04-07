package com.shizhefei.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.shizhefei.test.load.LoadViewHelper;
import com.shizhefei.view.loadview.R;
import com.shizhefei.view.vary.VaryViewHelperX;

public class Example2Activity extends Activity {

	private EditText editText;
	private WebView webView;
	private LoadViewHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example2);
		editText = (EditText) findViewById(R.id.editText1);
		webView = (WebView) findViewById(R.id.webView1);
		helper = new LoadViewHelper(new VaryViewHelperX(webView));
		webView.setWebViewClient(webViewClient);
		webView.loadUrl(editText.getText().toString());
	}

	public void clickLoad(View view) {
		webView.loadUrl(editText.getText().toString());
	}

	private WebViewClient webViewClient = new WebViewClient() {
		@Override
		public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			helper.showLoading("");
		};

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			helper.restore();
		};

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}

	};

}
