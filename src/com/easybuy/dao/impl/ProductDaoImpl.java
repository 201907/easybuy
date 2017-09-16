package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.Order;
import com.easybuy.bean.Product;
import com.easybuy.dao.ProductDao;
import com.easybuy.utils.DBManager;

public class ProductDaoImpl implements ProductDao {
	@Override
	public Product queryProductById(Connection conn, int id) throws SQLException {
		Product product = null;
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_product where id = ?")){
			ps.setInt(1, id);
			try(ResultSet rs=ps.executeQuery()){
				if(rs.next()) {
					product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getFloat("price"));
					product.setStock(rs.getInt("stock"));
					product.setCategorylevel1(rs.getInt("categoryLevel1"));
					product.setCategorylevel2(rs.getInt("categoryLevel2"));
					product.setCategorylevel3(rs.getInt("categoryLevel3"));
					product.setFilename(rs.getString("fileName"));
					product.setIsdelete(rs.getInt("isDelete"));
				}
			}
		}
		return product;
	}

	@Override
	public List<Product> queryAllProduct(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
