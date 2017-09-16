package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.User;
import com.easybuy.bean.UserAddress;
import com.easybuy.service.UserAddressService;
import com.easybuy.service.impl.UserAddressServiceImpl;

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet{
	private UserAddressService userAddressService = new UserAddressServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserAddress address = new UserAddress();
		String result = null;
		//获取用户ID
		int userId = ((User)req.getSession().getAttribute("login")).getId();
		address.setAddress(req.getParameter("address"));
		address.setArea(req.getParameter("country")+
				req.getParameter("province")+
				req.getParameter("city")+
				req.getParameter("area"));
		address.setEmail(req.getParameter("email"));
		address.setMobile(req.getParameter("mobile"));
		address.setPostcodes(req.getParameter("postcodes"));
		address.setReceiver(req.getParameter("name"));
		address.setUserId(userId);
		if(userAddressService.addUserAddress(address)==0) {
			result = "<script>alert('添加失败');location.href='Member_Address.jsp';</script>";
		}else {
			result = "<script>alert('添加成功');location.href='Member_Address.jsp';</script>";
		}
		resp.getWriter().println(result);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
