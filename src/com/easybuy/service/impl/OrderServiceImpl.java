package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.Order;
import com.easybuy.bean.OrderDetail;
import com.easybuy.dao.OrderDao;
import com.easybuy.dao.OrderDetailDao;
import com.easybuy.dao.impl.OrderDaoImpl;
import com.easybuy.dao.impl.OrderDetailDaoImpl;
import com.easybuy.service.OrderService;
import com.easybuy.utils.DBManager;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderServiceImpl implements OrderService {
	private DBManager dbManager = DBManager.getInstance();
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	/**
	 * 添加订单
	 */
	@Override
	public int addOrder(Order order) {
		int result = 0;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			result = orderDao.addOrder(conn, order);
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
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
	public List<Order> queryOrderByUserId(int id) {
		Connection conn = null;
		List<Order> orderList = null;
		try {
			conn = dbManager.getConn();
			orderList = orderDao.queryOrderByUserId(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return orderList;
	}

	@Override
	public int addOrderAndDetail(Order order, List<BuyCar> buycarList) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			orderDao.addOrder(conn, order);
			for(int i=0;i<buycarList.size();i++){
				//获取对应商品id
				int productid = buycarList.get(i).getProduct().getId();
				//获取购买数量
				int quantity = buycarList.get(i).getCount();
				//生成单个商品的总花费
				Float cost1 = buycarList.get(i).getProduct().getPrice()*quantity;
				//创建OrderDetail对象赋值并放入数据库中
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderid(order.getSerialnumber());
				orderDetail.setProductid(productid);
				orderDetail.setQuantity(quantity);
				orderDetail.setCost(cost1);
				orderDetailDao.addOrderDetail(conn, orderDetail);
				conn.commit();
			}
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
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return result;
	}

}
