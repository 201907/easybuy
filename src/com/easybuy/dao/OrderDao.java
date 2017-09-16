package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.Order;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	int addOrder(Connection conn,Order order) throws SQLException;
	/**
	 * 根据用户id查询所有订单
	 * @param id
	 * @return
	 */
	List<Order> queryOrderByUserId(Connection conn,int userId) throws SQLException;
}
