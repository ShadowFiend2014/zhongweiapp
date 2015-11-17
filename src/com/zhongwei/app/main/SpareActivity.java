package com.zhongwei.app.main;

import com.zhongwei.app.asynctask.HttpAsyncTaskBase;
import com.zhongwei.app.http.HttpMethod;
import com.zhongwei.app.info.SpareSearchRqInfo;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Cheng.xie 闲置备件页面
 * 
 */
public class SpareActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_unused_spares);
		SpareSearchRqInfo info = SpareSearchRqInfo.getIntance();
		HttpAsyncTaskBase h = new HttpAsyncTaskBase(this, info,HttpMethod.HTTP_METHOD_GET_UNUSEDSPARE);
		h.execute("");
		super.onCreate(savedInstanceState);
	}

}
