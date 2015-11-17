package com.zhongwei.app.info;

/**
 * 
 * @author Cheng.xie 商品搜索请求信息
 * 
 */
public class GoodsSearchRqInfo {
	private static GoodsSearchRqInfo requestInfo;

	/*
	 * 商品搜索关键字
	 */
	private String goodsKey;
	/*
	 * 请求页数，一次返回数据10个，总页数由商品总数/10获得
	 */
	private int page;
	/*
	 * 分类ID，例，电源板，主板，Y板
	 */
	private String catId;
	/*
	 * 品牌ID
	 */
	private String brandId;

	
	
	private GoodsSearchRqInfo() {

	}

	public static GoodsSearchRqInfo getIntance() {
		if (requestInfo == null) {
			requestInfo = new GoodsSearchRqInfo();
		}
		return requestInfo;
	}

	/**
	 * @return goodsKey
	 */
	public String getGoodsKey() {
		return goodsKey;
	}

	/**
	 * @param goodsKey
	 *            要设置的 goodsKey
	 */
	public void setGoodsKey(String goodsKey) {
		this.goodsKey = goodsKey;
	}

	/**
	 * @return page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            要设置的 page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return catId
	 */
	public String getCatId() {
		return catId;
	}

	/**
	 * @param catId
	 *            要设置的 catId
	 */
	public void setCatId(String catId) {
		this.catId = catId;
	}

	/**
	 * @return brandId
	 */
	public String getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId
	 *            要设置的 brandId
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

}
