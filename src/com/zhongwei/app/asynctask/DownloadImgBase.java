package com.zhongwei.app.asynctask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.zhongwei.app.handler.DownloadImgHandler;

/**
 * 
 * @author Cheng.xie 图片下载类
 * 
 */
public class DownloadImgBase extends AsyncTask<String, String, String> {

	private String imgUrl;
	private DownloadImgHandler mDownloadImgHandler;
	private Drawable mDrawable = null;

	public DownloadImgBase(String imgUrl, DownloadImgHandler mDownloadImgHandler) {
		this.imgUrl = imgUrl;
		this.mDownloadImgHandler = mDownloadImgHandler;
	}

	@Override
	protected void onPostExecute(String result) {
		if (mDrawable != null && mDownloadImgHandler != null) {
			mDownloadImgHandler.downloadImgHandler(mDrawable);
		}
		super.onPostExecute(result);
	}

	@Override
	protected String doInBackground(String... arg0) {
		try {
			mDrawable = Drawable.createFromStream(new URL(imgUrl).openStream(),
					"");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
