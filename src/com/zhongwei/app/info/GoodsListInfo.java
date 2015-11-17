package com.zhongwei.app.info;

import java.util.List;
/**
 * 商品返回信息列表
 * @author Cheng.xie
 *
 */
public class GoodsListInfo {
	/*
	 * 搜索成功与否，1为成功，0为失败
	 */
	private String result;
	/*
	 * 搜索商品总数
	 */
	private String msg;
	/*
	 * 一条数据返回的商品数
	 */
	private int rowNum;
	/*
	 * 商品信息列表
	 */
	private List<GoodsBaseInfo> data;

	/**
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            要设置的 result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            要设置的 msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return rowNum
	 */
	public int getRowNum() {
		return rowNum;
	}

	/**
	 * @param rowNum
	 *            要设置的 rowNum
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	/**
	 * @return data
	 */
	public List<GoodsBaseInfo> getData() {
		return data;
	}

	/**
	 * @param data
	 *            要设置的 data
	 */
	public void setData(List<GoodsBaseInfo> data) {
		this.data = data;
	}
}
