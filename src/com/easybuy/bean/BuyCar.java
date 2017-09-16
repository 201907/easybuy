package com.easybuy.bean;

/**
 * 购物车
 * @author Administrator
 *
 * @param 
 */
public class BuyCar {
	/**
	 * 购买的数量
	 */
	private Integer count;
	/**
	 * 具体购买的产品
	 */
	private Product product;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 购物车id
	 */
	private Long id;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
