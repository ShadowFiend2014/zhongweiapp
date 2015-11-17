package com.zhongwei.app.handler;

import com.zhongwei.app.info.GoodsListInfo;
/**
 * 
 * @author Cheng.xie 
 *
 */
public interface SearchGoodsCompleteHandler {

	/**
	 * 搜索完成通知
	 * @param listInfo
	 */
	void SearchCompleteHandler(GoodsListInfo listInfo);
}
