package com.zhongwei.app.info;

import android.graphics.drawable.Drawable;

/**
 * 
 * @author Cheng.xie 商品信息类
 * 
 */
public class GoodsBaseInfo {
	/*
	 * 商品ID
	 */
	private String goods_id;
	/*
	 * 商品SN号
	 */
	private String goods_sn;
	/*
	 * 商品名称
	 */
	private String goods_name;
	/*
	 * 商店价格
	 */
	private String shop_price;
	/*
	 * 市场价格
	 */
	private String market_price;
	/*
	 * 商品缩略图地址
	 */
	private String goods_thumb;
	/*
	 * 商品大图地址
	 */
	private String goods_img;
	/*
	 * 描述，一般为适配机型
	 */
	private String sContent;
	/*
	 * 商品库存
	 */
	private int goods_num;
	
    /*
     * 商品缩略图
     */
	private Drawable goodsTumbDrawable;
	/**
	 * @return goods_Id
	 */
	public String getGoods_Id() {
		return goods_id;
	}

	/**
	 * @param goods_Id
	 *            要设置的 goods_Id
	 */
	public void setGoods_Id(String goods_Id) {
		this.goods_id = goods_Id;
	}

	/**
	 * @return goods_Sn
	 */
	public String getGoods_Sn() {
		return goods_sn;
	}

	/**
	 * @param goods_Sn
	 *            要设置的 goods_Sn
	 */
	public void setGoods_Sn(String goods_Sn) {
		this.goods_sn = goods_Sn;
	}

	/**
	 * @return goods_Name
	 */
	public String getGoods_Name() {
		return goods_name;
	}

	/**
	 * @param goods_Name
	 *            要设置的 goods_Name
	 */
	public void setGoods_Name(String goods_Name) {
		this.goods_name = goods_Name;
	}

	/**
	 * @return shop_Price
	 */
	public String getShop_Price() {
		return shop_price;
	}

	/**
	 * @param shop_Price
	 *            要设置的 shop_Price
	 */
	public void setShop_Price(String shop_Price) {
		this.shop_price = shop_Price;
	}

	/**
	 * @return market_Price
	 */
	public String getMarket_Price() {
		return market_price;
	}

	/**
	 * @param market_Price
	 *            要设置的 market_Price
	 */
	public void setMarket_Price(String market_Price) {
		this.market_price = market_Price;
	}

	/**
	 * @return goods_thumb
	 */
	public String getGoods_thumb() {
		return goods_thumb;
	}

	/**
	 * @param goods_thumb
	 *            要设置的 goods_thumb
	 */
	public void setGoods_thumb(String goods_thumb) {
		this.goods_thumb = goods_thumb;
	}

	/**
	 * @return goods_img
	 */
	public String getGoods_img() {
		return goods_img;
	}

	/**
	 * @param goods_img
	 *            要设置的 goods_img
	 */
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	/**
	 * @return sContent
	 */
	public String getsContent() {
		return sContent;
	}

	/**
	 * @param sContent
	 *            要设置的 sContent
	 */
	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	/**
	 * @return goods_num
	 */
	public int getGoods_num() {
		return goods_num;
	}

	/**
	 * @param goods_num
	 *            要设置的 goods_num
	 */
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	/**
	 * @return goodsTumbDrawable
	 */
	public Drawable getGoodsTumbDrawable() {
		return goodsTumbDrawable;
	}

	/**
	 * @param goodsTumbDrawable 要设置的 goodsTumbDrawable
	 */
	public void setGoodsTumbDrawable(Drawable goodsTumbDrawable) {
		this.goodsTumbDrawable = goodsTumbDrawable;
	}
}
