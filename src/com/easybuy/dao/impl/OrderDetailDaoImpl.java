package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.News;
import com.easybuy.bean.OrderDetail;
import com.easybuy.dao.OrderDetailDao;
import com.easybuy.utils.DBManager;

public class OrderDetailDaoImpl implements OrderDetailDao {
	/**
	 * 添加订单详情
	 */
	@Override
	public int addOrderDetail(Connection conn, OrderDetail orderDetail) throws SQLException {
		int result = 0;
		try(PreparedStatement ps=conn.prepareStatement("insert into easybuy_order_detail values (id,?,?,?,?)")){
			ps.setString(1, orderDetail.getOrderid());
			ps.setInt(2, orderDetail.getProductid());
			ps.setInt(3, orderDetail.getQuantity());
			ps.setFloat(4, orderDetail.getCost());
			result = ps.executeUpdate();
		}
		return result;
	}

	@Override
	public List<OrderDetailDao> queryOrderDetailByUserId(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
