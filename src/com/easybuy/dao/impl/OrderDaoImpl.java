package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.Order;
import com.easybuy.dao.OrderDao;
import com.easybuy.utils.DBManager;
import com.google.common.collect.Lists;

public class OrderDaoImpl implements OrderDao {
	/**
	 * 添加订单
	 */
	@Override
	public int addOrder(Connection conn, Order order) throws SQLException {
		int result = 0;
		try(PreparedStatement ps=conn.prepareStatement("insert into easybuy_order values (id,?,?,?,now(),?,?,?,?)")){
			ps.setObject(1, order.getUserid());
			ps.setString(2, order.getLoginname());
			ps.setString(3, order.getUseraddress());
			ps.setFloat(4, order.getCost());
			ps.setInt(5, order.getStatus());
			ps.setObject(6, order.getType());
			ps.setString(7, order.getSerialnumber());
			result = ps.executeUpdate();
		}
		return result;
	}

	@Override
	public List<Order> queryOrderByUserId(Connection conn, int userId) throws SQLException {
		List<Order> orderList = null;
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_order where userId = ?")){
			ps.setInt(1, userId);
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					if(orderList==null)orderList = Lists.newArrayList();
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setUserid(rs.getInt("userId"));
					order.setLoginname(rs.getString("loginName"));
					order.setUseraddress(rs.getString("userAddress"));
					order.setCreatetime(rs.getDate("createTime"));
					order.setCost(rs.getFloat("cost"));
					order.setStatus(rs.getInt("status"));
					order.setType(rs.getInt("type"));
					order.setSerialnumber(rs.getString("serialNumber"));
					orderList.add(order);
				}
			}
		}
		return orderList;
	}


}
