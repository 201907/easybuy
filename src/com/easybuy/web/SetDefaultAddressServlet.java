package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.User;
import com.easybuy.service.UserAddressService;
import com.easybuy.service.impl.UserAddressServiceImpl;

@WebServlet("/setDefaultAddressServlet")
public class SetDefaultAddressServlet extends HttpServlet{
	private UserAddressService userAddressService = new UserAddressServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取地址id
		int addressId = Integer.valueOf(req.getParameter("id"));
		//获取用户id
		int userId = ((User)req.getSession().getAttribute("login")).getId();
		//将其设置为默认地址
		int result = userAddressService.setDefaultAddress(userId, addressId);
		if(result!=0) {
			resp.getWriter().print("success");
		}else {
			resp.getWriter().print("failed");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
