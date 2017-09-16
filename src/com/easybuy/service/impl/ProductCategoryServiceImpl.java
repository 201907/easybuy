package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.ProductCategory;
import com.easybuy.dao.ProductCategoryDao;
import com.easybuy.dao.impl.ProductCategoryDaoImpl;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.utils.DBManager;

public class ProductCategoryServiceImpl implements ProductCategoryService {
	private DBManager dbManager = DBManager.getInstance();
	private ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();
	@Override
	public List<ProductCategory> queryAllProductCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> queryProductCategoryByType(int type) {
		List<ProductCategory> productCategories = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			productCategories = productCategoryDao.queryProductCategoryByType(conn, type);
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
		return productCategories;
	}

	@Override
	public List<ProductCategory> queryProductCategoryByTypeAndParent(int type, int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
