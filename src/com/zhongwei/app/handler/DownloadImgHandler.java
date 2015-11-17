package com.zhongwei.app.handler;

import android.graphics.drawable.Drawable;

/**
 * 
 * @author Cheng.xie 
 *
 */
public interface DownloadImgHandler {
     /**
      * 图片下载完成通知
      * @param drawable
      */
	void downloadImgHandler(Drawable drawable);
}
