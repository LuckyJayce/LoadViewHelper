# LoadViewHelper
切换加载中，加载失败，加载成功布局，定义一个LoadViewHelper所有界面通用。


    LoadViewHelper helper = new LoadViewHelper(listView);  
	  //将listview切换成显示加载中布局  
		helper.showLoading("加载中...");  
		//将listview切换成显示空数据布局
		helper.showEmpty("暂无数据", "重试", new OnClickListener() {  

			@Override  
			public void onClick(View v) {  
  
			}  
		});  
