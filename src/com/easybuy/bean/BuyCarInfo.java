package com.easybuy.bean;


public class BuyCarInfo {
	/**
	 * 购物车有多少产品
	 */
	private int productCount;
	/**
	 * 购物车里所有产品的总价
	 */
	private float total;
	/**
	 * 状态
	 */
	private boolean isSuccess;
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
