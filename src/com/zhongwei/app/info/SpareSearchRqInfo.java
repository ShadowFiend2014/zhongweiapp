package com.zhongwei.app.info;

public class SpareSearchRqInfo {

	private static SpareSearchRqInfo requestInfo;
	/*
	 * 请求页数
	 */
	private int page;
	/*
	 * 搜索关键字
	 */
	private String key;
	/*
	 * 用户ID（搜索用户自己发布的闲置备件需用）
	 */
	private String userId;
	/*
	 * 产品ID（搜索备件详情需用）
	 */
	private String productId;

	private SpareSearchRqInfo() {

	}

	public static SpareSearchRqInfo getIntance() {
		if (requestInfo == null)
			requestInfo = new SpareSearchRqInfo();

		return requestInfo;
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
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            要设置的 key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            要设置的 productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
