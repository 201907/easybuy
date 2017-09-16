package com.easybuy.service;

import java.sql.Connection;
import java.util.List;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.Order;

public interface OrderService {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	int addOrder(Order order);
	/**
	 * 根据用户id查询所有订单
	 * @param id
	 * @return
	 */
	List<Order> queryOrderByUserId(int id);
	/**
	 * 添加订单与订单详情
	 * @param order
	 * @param buycarList
	 * @return
	 */
	int addOrderAndDetail(Order order,List<BuyCar> buycarList);
}
