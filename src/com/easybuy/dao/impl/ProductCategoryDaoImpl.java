package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.Order;
import com.easybuy.bean.ProductCategory;
import com.easybuy.dao.ProductCategoryDao;
import com.easybuy.utils.DBManager;
import com.google.common.collect.Lists;

public class ProductCategoryDaoImpl implements ProductCategoryDao {

	@Override
	public List<ProductCategory> queryAllProductCategory(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> queryProductCategoryByType(Connection conn, int type) throws SQLException {
		List<ProductCategory> categories = null;
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_product_category where type = ?")){
			ps.setInt(1, type);
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					if(categories==null)categories=Lists.newArrayList();
					ProductCategory category = new ProductCategory();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setParentid(rs.getInt("parentId"));
					category.setType(rs.getInt("type"));
					categories.add(category);
				}
			}
		}
		return categories;
	}

	@Override
	public List<ProductCategory> queryProductCategoryByTypeAndParent(Connection conn, int type, int parentId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
