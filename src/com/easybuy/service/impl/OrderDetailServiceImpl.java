package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.OrderDetail;
import com.easybuy.dao.OrderDetailDao;
import com.easybuy.dao.impl.OrderDetailDaoImpl;
import com.easybuy.service.OrderDetailService;
import com.easybuy.utils.DBManager;

public class OrderDetailServiceImpl implements OrderDetailService {
	private DBManager dbManager = DBManager.getInstance();
	private OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	/**
	 * 添加用户订单详情
	 */
	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		int result = 0;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			result = orderDetailDao.addOrderDetail(conn, orderDetail);
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<OrderDetailDao> queryOrderDetailByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
