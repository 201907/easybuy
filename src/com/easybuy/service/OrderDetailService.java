package com.easybuy.service;

import java.util.List;

import com.easybuy.bean.OrderDetail;
import com.easybuy.dao.OrderDetailDao;

public interface OrderDetailService {
	/**
	 * 添加订单详情
	 * @param orderDetail
	 * @return
	 */
	int addOrderDetail(OrderDetail orderDetail);
	/**
	 * 根据用户id查询所有的订单详情
	 * @param id
	 * @return
	 */
	List<OrderDetailDao>queryOrderDetailByUserId(int id);
}
