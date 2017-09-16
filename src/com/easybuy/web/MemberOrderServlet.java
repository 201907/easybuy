package com.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.Order;
import com.easybuy.bean.User;
import com.easybuy.service.OrderService;
import com.easybuy.service.impl.OrderServiceImpl;

@WebServlet("/memberOrderServlet")
public class MemberOrderServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = ((User)req.getSession().getAttribute("login")).getId();
		List<Order> orderList = orderService.queryOrderByUserId(userId);
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("Member_Order.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
