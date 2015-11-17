package com.zhongwei.app.main;

import java.util.ArrayList;
import java.util.List;

import com.zhongwei.app.adapter.SearchGoodsListAdapter;
import com.zhongwei.app.asynctask.HttpAsyncTaskBase;
import com.zhongwei.app.handler.SearchGoodsCompleteHandler;
import com.zhongwei.app.http.HttpMethod;
import com.zhongwei.app.info.GoodsBaseInfo;
import com.zhongwei.app.info.GoodsListInfo;
import com.zhongwei.app.info.GoodsSearchRqInfo;
import com.zhongwei.app.view.SwipeMenu;
import com.zhongwei.app.view.SwipeMenuCreator;
import com.zhongwei.app.view.SwipeMenuItem;
import com.zhongwei.app.view.SwipeMenuListView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * @author Cheng.xie 搜索页
 * 
 */
public class SearchActivity extends Activity implements OnClickListener,
		SearchGoodsCompleteHandler, OnScrollListener {

	private SwipeMenuListView listView;
	private SearchGoodsListAdapter mSearchGoodsListAdapter;
	private EditText mSearchKeyEditText;
	/*
	 * 商品信息列表
	 */
	private List<GoodsBaseInfo> goodsList;
	/*
	 * 请求第几页
	 */
	private int page;
	/*
	 * 消息总数
	 */
	private int msgSubNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		initView();
		initListView();

	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getResources().getDisplayMetrics());
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		Button searchBtn = (Button) findViewById(R.id.btn_search);
		searchBtn.setOnClickListener(this);
		mSearchKeyEditText = (EditText) findViewById(R.id.editText_search);
	}

	/**
	 * 初始化可左右滑动列表
	 */
	private void initListView() {
		listView = (SwipeMenuListView) findViewById(R.id.listView);
		goodsList = new ArrayList<GoodsBaseInfo>();
		mSearchGoodsListAdapter = new SearchGoodsListAdapter(this, goodsList);
		listView.setAdapter(mSearchGoodsListAdapter);
		listView.setOnScrollListener(this);
		SwipeMenuCreator creator = new SwipeMenuCreator() {

			@Override
			public void create(SwipeMenu menu) {
				switch (menu.getViewType()) {
				case 0:
					createMenu1(menu);
					break;
				}
			}

			@SuppressLint("ResourceAsColor")
			private void createMenu1(SwipeMenu menu) {
				SwipeMenuItem item1 = new SwipeMenuItem(getApplicationContext());
				item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0x18,
						0x5E)));
				item1.setWidth(dp2px(90));
				item1.setTitle(R.string.qq_listitem);
				item1.setTitleColor(R.color.white);
				item1.setTitleSize(20);
				menu.addMenuItem(item1);
				SwipeMenuItem item2 = new SwipeMenuItem(getApplicationContext());
				item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
						0xCE)));
				item2.setWidth(dp2px(90));
				item2.setTitle(R.string.buynow_listitem);
				item2.setTitleColor(R.color.white);
				item2.setTitleSize(20);
				menu.addMenuItem(item2);
			}
		};
		listView.setMenuCreator(creator);
		listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(int position, SwipeMenu menu,
					int index) {
				switch (index) {
				case 0:
					Toast.makeText(SearchActivity.this, "QQ咨询",
							Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(SearchActivity.this, "立即购买",
							Toast.LENGTH_SHORT).show();
					break;
				}
				return false;
			}
		});

	}

	@Override
	/**
	 * 监听搜索返回数据
	 */
	public void SearchCompleteHandler(GoodsListInfo listInfo) {
		if (listInfo == null) {
			Toast.makeText(this, "没搜索到相关内容", Toast.LENGTH_SHORT).show();
			return;
		}
		if (listInfo.getRowNum() >= Integer.parseInt(listInfo.getMsg())) {
			msgSubNum = 1;
		} else {
			msgSubNum = Integer.parseInt(listInfo.getMsg())
					/ listInfo.getRowNum();
		}
		goodsList.addAll(listInfo.getData());
		mSearchGoodsListAdapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_search:
			if (mSearchKeyEditText.getText().length() == 0) {
				Toast.makeText(this, "搜索关键字不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			goodsList.clear();
			mSearchGoodsListAdapter.notifyDataSetChanged();
			// 获取商品信息列表
			GoodsSearchRqInfo requestInfo = GoodsSearchRqInfo.getIntance();
			requestInfo.setGoodsKey(mSearchKeyEditText.getText().toString());
			requestInfo.setPage(1);
			page = 1;
			new HttpAsyncTaskBase(this, this, requestInfo,
					HttpMethod.HTTP_METHOD_GET_GOODSLISTINFO).execute("");
			break;

		default:
			break;
		}
	}

	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {

	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// 当不滚动时
		if (arg1 == OnScrollListener.SCROLL_STATE_IDLE) {

			// 判断是否滚动到底部
			if (arg0.getLastVisiblePosition() == arg0.getCount() - 1) {
				++page;
				if (page > msgSubNum) {
					Toast.makeText(this, "没有更多内容了", Toast.LENGTH_SHORT).show();
					return;
				}
				GoodsSearchRqInfo requestInfo = GoodsSearchRqInfo.getIntance();
				requestInfo.setPage(page);
				new HttpAsyncTaskBase(this, this, requestInfo,
						HttpMethod.HTTP_METHOD_GET_GOODSLISTINFO).execute("");
			}
		}
	}
}