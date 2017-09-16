package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 查询所有的产品分类
	 * @return
	 */
	List<ProductCategory> queryAllProductCategory(Connection conn) throws SQLException;
	/**
	 * 根据分类级别查询产品分类
	 * @param type
	 * @return
	 */
	List<ProductCategory> queryProductCategoryByType(Connection conn,int type) throws SQLException;
	/**
	 * 根据分类级别和对应的父分类查询产品分类
	 * @param type
	 * @param parentId
	 * @return
	 */
	List<ProductCategory> queryProductCategoryByTypeAndParent(Connection conn,int type,int parentId) throws SQLException;
}
