package com.zhongwei.app.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * 主页面
 * 
 * @author Cheng.xie
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		RelativeLayout searchLayout = (RelativeLayout) findViewById(R.id.search_layout);
		RelativeLayout collectLayout = (RelativeLayout) findViewById(R.id.btn_collect);
		RelativeLayout issueLayout = (RelativeLayout) findViewById(R.id.btn_issue);
		RelativeLayout mineLayout = (RelativeLayout) findViewById(R.id.btn_mine);
		Button btnUnUsedSpares = (Button) findViewById(R.id.btn_unused_spares);
		Button btnServiceOrder = (Button) findViewById(R.id.btn_service_order);
		collectLayout.setOnClickListener(this);
		issueLayout.setOnClickListener(this);
		mineLayout.setOnClickListener(this);
		btnUnUsedSpares.setOnClickListener(this);
		btnServiceOrder.setOnClickListener(this);
		searchLayout.setOnClickListener(this);
	}

	@Override
	/**
	 * 控件点击事件监听
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		/*
		 * 搜索
		 */
		case R.id.search_layout:

			Intent intentSearch = new Intent(this, SearchActivity.class);
			startActivity(intentSearch);
			break;
		/*
		 * 闲置备件
		 */
		case R.id.btn_unused_spares:
			Intent intentUnusedSpares = new Intent(this,
					SpareActivity.class);
			startActivity(intentUnusedSpares);
			break;
		/*
		 * 维修订单
		 */
		case R.id.btn_service_order:
			Intent intentServiceOrder = new Intent(this,
					ServiceOrderActivity.class);
			startActivity(intentServiceOrder);
			break;
		/*
		 * 收藏
		 */
		case R.id.btn_collect:

			break;
		/*
		 * 发布
		 */
		case R.id.btn_issue:
			break;
		/*
		 * 我的
		 */
		case R.id.btn_mine:

			break;
		default:
			break;
		}
	}
}
