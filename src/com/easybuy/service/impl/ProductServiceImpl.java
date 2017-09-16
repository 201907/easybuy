package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.Product;
import com.easybuy.dao.ProductDao;
import com.easybuy.dao.impl.ProductDaoImpl;
import com.easybuy.service.ProductService;
import com.easybuy.utils.DBManager;

public class ProductServiceImpl implements ProductService{
	private DBManager dbManager = DBManager.getInstance();
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public Product queryProductById(int id) {
		Connection conn = null;
		Product product = null;
		try {
			conn = dbManager.getConn();
			product = productDao.queryProductById(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public List<Product> queryAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
