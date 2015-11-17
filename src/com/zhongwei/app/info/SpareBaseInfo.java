package com.zhongwei.app.info;

/**
 * 
 * @author Cheng.xie 闲置备件基本信息类
 * 
 */
public class SpareBaseInfo {

	/*
	 * 闲置备件ID
	 */
	private String product_id;
	/*
	 * 发布的标题
	 */
	private String good_title;
	/*
	 * 发布的价格
	 */
	private String goods_price;
	/*
	 * 发布人拥有的备件数量，若是设计界面没有，默认发送1
	 */
	private String goods_number;
	/*
	 * 备件描述
	 */
	private String good_desc;
	/*
	 * 用户id
	 */
	private String user_id;
	/*
	 * 联系电话
	 */
	private String link_tel;
	/*
	 * 图片路径1
	 */
	private String good_pic1;
	/*
	 * 图片路径2
	 */
	private String good_pic2;
	/*
	 * 图片路径3
	 */
	private String good_pic3;
	/*
	 * 用户地址
	 */
	private String user_address;
	/*
	 * 审核状态：0未审核，1审核通过，2审核失败
	 */
	private String check_status;
	/*
	 * 发布状态：0发布，1下架
	 */
	private String pay_status;

	/**
	 * @return product_id
	 */
	public String getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id
	 *            要设置的 product_id
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return good_title
	 */
	public String getGood_title() {
		return good_title;
	}

	/**
	 * @param good_title
	 *            要设置的 good_title
	 */
	public void setGood_title(String good_title) {
		this.good_title = good_title;
	}

	/**
	 * @return goods_price
	 */
	public String getGoods_price() {
		return goods_price;
	}

	/**
	 * @param goods_price
	 *            要设置的 goods_price
	 */
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	/**
	 * @return goods_number
	 */
	public String getGoods_number() {
		return goods_number;
	}

	/**
	 * @param goods_number
	 *            要设置的 goods_number
	 */
	public void setGoods_number(String goods_number) {
		this.goods_number = goods_number;
	}

	/**
	 * @return good_desc
	 */
	public String getGood_desc() {
		return good_desc;
	}

	/**
	 * @param good_desc
	 *            要设置的 good_desc
	 */
	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}

	/**
	 * @return user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            要设置的 user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return link_tel
	 */
	public String getLink_tel() {
		return link_tel;
	}

	/**
	 * @param link_tel
	 *            要设置的 link_tel
	 */
	public void setLink_tel(String link_tel) {
		this.link_tel = link_tel;
	}

	/**
	 * @return good_pic1
	 */
	public String getGood_pic1() {
		return good_pic1;
	}

	/**
	 * @param good_pic1
	 *            要设置的 good_pic1
	 */
	public void setGood_pic1(String good_pic1) {
		this.good_pic1 = good_pic1;
	}

	/**
	 * @return good_pic2
	 */
	public String getGood_pic2() {
		return good_pic2;
	}

	/**
	 * @param good_pic2
	 *            要设置的 good_pic2
	 */
	public void setGood_pic2(String good_pic2) {
		this.good_pic2 = good_pic2;
	}

	/**
	 * @return good_pic3
	 */
	public String getGood_pic3() {
		return good_pic3;
	}

	/**
	 * @param good_pic3
	 *            要设置的 good_pic3
	 */
	public void setGood_pic3(String good_pic3) {
		this.good_pic3 = good_pic3;
	}

	/**
	 * @return user_address
	 */
	public String getUser_address() {
		return user_address;
	}

	/**
	 * @param user_address
	 *            要设置的 user_address
	 */
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	/**
	 * @return check_status
	 */
	public String getCheck_status() {
		return check_status;
	}

	/**
	 * @param check_status
	 *            要设置的 check_status
	 */
	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}

	/**
	 * @return pay_status
	 */
	public String getPay_status() {
		return pay_status;
	}

	/**
	 * @param pay_status
	 *            要设置的 pay_status
	 */
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
}
