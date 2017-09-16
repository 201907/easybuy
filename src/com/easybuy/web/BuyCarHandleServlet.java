package com.easybuy.web;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.User;
import com.easybuy.service.BuyCarService;
import com.easybuy.service.impl.BuyCarServiceImpl;

@WebServlet("/buyCarHandleServlet")
public class BuyCarHandleServlet extends HttpServlet{
	//guava缓存的工具类保存购物车数据
	private BuyCarService buyCarService = new BuyCarServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		//获取用户id
		int userId = ((User)req.getSession().getAttribute("login")).getId();
		//获取购物车id
		long buyCarId = Long.valueOf(req.getParameter("id"));
		switch(type) {
			case "changecount":
				try {
				//获取产品更新的数量
				int count = Integer.valueOf(req.getParameter("count"));
				buyCarService.updateProductCount(userId, buyCarId, count);
				//返回总价
				resp.getWriter().print(buyCarService.getSumPrice(userId));
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					resp.getWriter().print(0);
				}
				break;
			case "delete":
				try {
					buyCarService.deleteBuyCar(userId, buyCarId);
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//跳转
				resp.sendRedirect("buyCarServlet");
				break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
