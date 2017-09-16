package com.easybuy.web;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.User;
import com.easybuy.bean.UserAddress;
import com.easybuy.service.BuyCarService;
import com.easybuy.service.UserAddressService;
import com.easybuy.service.impl.BuyCarServiceImpl;
import com.easybuy.service.impl.UserAddressServiceImpl;

@WebServlet("/buyCarTwoServlet")
public class BuyCarTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserAddressService userAddressService = new UserAddressServiceImpl();
	private BuyCarService buyCarService = new BuyCarServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAddressService uas = new UserAddressServiceImpl();
		User user = (User) session.getAttribute("login");
		int userId = user.getId();
		//获取用户默认地址并放入session中
		UserAddress defaultAddress = userAddressService.getUserDefaultAddress(userId);
		try {
			request.setAttribute("buycar", buyCarService.getBuyCar(userId));
			request.setAttribute("defaultAddress", defaultAddress);
			request.getRequestDispatcher("BuyCar_Two.jsp").forward(request, response);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
