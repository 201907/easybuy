package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.OrderDetail;

public interface OrderDetailDao {
	/**
	 * 添加订单详情
	 * @param orderDetail
	 * @return
	 */
	int addOrderDetail(Connection conn,OrderDetail orderDetail) throws SQLException;
	/**
	 * 根据用户id查询所有的订单详情
	 * @param id
	 * @return
	 */
	List<OrderDetailDao>queryOrderDetailByUserId(String sql) throws SQLException;
}
