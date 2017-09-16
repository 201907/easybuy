package com.easybuy.service;

import java.util.List;

import com.easybuy.bean.Product;

public interface ProductService {
	/**
	 * 根据产品id查找相应的产品
	 * @param id
	 * @return
	 */
	Product queryProductById(int id);
	/**
	 * 查询所有的产品
	 * @return
	 */
	List<Product> queryAllProduct();
}
