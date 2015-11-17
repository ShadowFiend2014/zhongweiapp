package com.zhongwei.app.asynctask;

import com.zhongwei.app.handler.SearchGoodsCompleteHandler;
import com.zhongwei.app.http.HttpMethod;
import com.zhongwei.app.info.GoodsListInfo;
import com.zhongwei.app.info.GoodsSearchRqInfo;
import com.zhongwei.app.info.SpareListInfo;
import com.zhongwei.app.info.SpareSearchRqInfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class HttpAsyncTaskBase extends AsyncTask<String, String, String> {
	private ProgressDialog mypDialog;
	private GoodsSearchRqInfo requestInfo;
	private SearchGoodsCompleteHandler mHandler;
	private GoodsListInfo mGoodsListInfo;
	private SpareListInfo mUnusedSpareListInfo;
	private SpareSearchRqInfo mUnusedSpareSearchRqInfo;
	private Context context;
	private int httpMethodId;

	public HttpAsyncTaskBase(Context context,
			SearchGoodsCompleteHandler handler, GoodsSearchRqInfo requestInfo,int httpMethodId) {
		this.requestInfo = requestInfo;
		this.mHandler = handler;
		this.context = context;
		this.httpMethodId = httpMethodId;
	}

	public HttpAsyncTaskBase(Context context,SpareSearchRqInfo requestInfo,int httpMethodId){
		this.context = context;
		this.httpMethodId = httpMethodId;
  this.mUnusedSpareSearchRqInfo = requestInfo;
	}
	@Override
	protected void onPreExecute() {
		mypDialog = new ProgressDialog(context);
		mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mypDialog.setCancelable(false);
		mypDialog.show();
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(String... params) {
		switch (httpMethodId) {
		case HttpMethod.HTTP_METHOD_GET_GOODSLISTINFO:
			mGoodsListInfo = HttpMethod.getGoodsInfoList(requestInfo);
			break;
		case HttpMethod.HTTP_METHOD_GET_UNUSEDSPARE:
			mUnusedSpareListInfo =HttpMethod.getUnusedSpareList(mUnusedSpareSearchRqInfo);
			break;
		default:
			break;
		}
		

		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		switch (httpMethodId) {
		case HttpMethod.HTTP_METHOD_GET_GOODSLISTINFO:
			mHandler.SearchCompleteHandler(mGoodsListInfo);
			break;
		default:
			break;
		}

		mypDialog.dismiss();
		super.onPostExecute(result);
	}

}
