package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.Product;

public interface ProductDao {
	/**
	 * 根据产品id查找相应的产品
	 * @param id
	 * @return
	 */
	Product queryProductById(Connection conn,int id) throws SQLException;
	/**
	 * 查询所有的产品
	 * @return
	 */
	List<Product> queryAllProduct(String sql) throws SQLException;
}
