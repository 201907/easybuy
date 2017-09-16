package com.easybuy.service;

import java.util.List;

import com.easybuy.bean.ProductCategory;

public interface ProductCategoryService {
	/**
	 * 查询所有的产品分类
	 * @return
	 */
	List<ProductCategory> queryAllProductCategory();
	/**
	 * 根据分类级别查询产品分类
	 * @param type
	 * @return
	 */
	List<ProductCategory> queryProductCategoryByType(int type);
	/**
	 * 根据分类级别和对应的父分类查询产品分类
	 * @param type
	 * @param parentId
	 * @return
	 */
	List<ProductCategory> queryProductCategoryByTypeAndParent(int type,int parentId);
}
