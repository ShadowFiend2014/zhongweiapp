package com.zhongwei.app.http;

import com.alibaba.fastjson.JSON;
import com.zhongwei.app.info.GoodsListInfo;
import com.zhongwei.app.info.GoodsSearchRqInfo;
import com.zhongwei.app.info.SpareListInfo;
import com.zhongwei.app.info.SpareSearchRqInfo;
import com.zhongwei.app.utils.ZwLog;

/**
 * 
 * @author Cheng.xie HTTP请求方法类
 * 
 */
public class HttpMethod {
	/**
	 * 获取商品列表信息方法ID
	 */
	public final static int HTTP_METHOD_GET_GOODSLISTINFO = 0;
	/**
	 * 获取闲置备件列表方法ID
	 */
	public final static int HTTP_METHOD_GET_UNUSEDSPARE = 1;
	/**
	 * 获取用户发布的闲置备件列表方法ID
	 */
	public final static int HTTP_METHOD_GET_USERSPARE = 2;
	/**
	 * 获取单个备件的详细信息方法ID
	 */
	public final static int HTTP_METHOD_GET_DETAILS = 3;

	/**
	 * 获取商品列表信息
	 * 
	 * @param requestInfo
	 * @return
	 */
	public static GoodsListInfo getGoodsInfoList(GoodsSearchRqInfo requestInfo) {

		String url = HttpUtils.MAIN_URL + HttpUtils.GET_GOODSINFO_LIST + "key="
				+ requestInfo.getGoodsKey() + "&cat_id=&brand_id=&page="
				+ Integer.toString(requestInfo.getPage());
		String result = HttpBase.httpGet(url);
		if (result == null) {
			ZwLog.e(ZwLog.TAG, "请求返回数据失败");
			return null;
		}
		GoodsListInfo listInfo = JSON.parseObject(result, GoodsListInfo.class);
		if (listInfo.getResult().equals(HttpUtils.RESULT_FAIL)) {
			ZwLog.e(ZwLog.TAG, "获取的数据失败");
			return null;
		}
		return listInfo;
	}

	/**
	 * 获取闲置备件列表
	 * 
	 * @param requestInfo
	 * @return
	 */
	public static SpareListInfo getUnusedSpareList(
			SpareSearchRqInfo requestInfo) {
		String url = HttpUtils.MAIN_URL + HttpUtils.GET_UNUSED_SPARE_LIST
				+ "act=list&page=" + Integer.toString(requestInfo.getPage())
				+ "&key=" + requestInfo.getKey();
		String result = HttpBase.httpGet(url);
		ZwLog.d("", result);
		if (result == null) {
			ZwLog.e(ZwLog.TAG, "请求返回数据失败");
			return null;
		}
		SpareListInfo listInfo = JSON.parseObject(result,
				SpareListInfo.class);
		if (listInfo.getResult().equals(HttpUtils.RESULT_FAIL)) {
			ZwLog.e(ZwLog.TAG, "获取的数据失败");
			return null;
		}
		return listInfo;

	}

	/**
	 * 获取用户发布的闲置备件列表
	 * 
	 * @param requestInfo
	 * @return
	 */
	public static SpareListInfo getUserSpareList(
			SpareSearchRqInfo requestInfo) {
		String url = HttpUtils.MAIN_URL + HttpUtils.GET_UNUSED_SPARE_LIST
				+ "act=userList&page="
				+ Integer.toString(requestInfo.getPage()) + "&user_id="
				+ requestInfo.getUserId();

		String result = HttpBase.httpGet(url);
		ZwLog.d("", result);
		if (result == null) {
			ZwLog.e(ZwLog.TAG, "请求返回数据失败");
			return null;
		}
		SpareListInfo listInfo = JSON.parseObject(result,
				SpareListInfo.class);
		if (listInfo.getResult().equals(HttpUtils.RESULT_FAIL)) {
			ZwLog.e(ZwLog.TAG, "获取的数据失败");
			return null;
		}
		return listInfo;

	}

	/**
	 * 获取备件详情
	 * 
	 * @param requestInfo
	 * @return
	 */
	public static SpareListInfo getSpareDetails(
			SpareSearchRqInfo requestInfo) {
		String url = HttpUtils.MAIN_URL + HttpUtils.GET_UNUSED_SPARE_LIST
				+ "act=info&product_id=" + requestInfo.getProductId();
		String result = HttpBase.httpGet(url);
		ZwLog.d("", result);
		if (result == null) {
			ZwLog.e(ZwLog.TAG, "请求返回数据失败");
			return null;
		}
		SpareListInfo listInfo = JSON.parseObject(result,
				SpareListInfo.class);
		if (listInfo.getResult().equals(HttpUtils.RESULT_FAIL)) {
			ZwLog.e(ZwLog.TAG, "获取的数据失败");
			return null;
		}
		return listInfo;

	}
}
