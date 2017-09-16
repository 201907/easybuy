package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.Order;
import com.easybuy.bean.User;
import com.easybuy.bean.UserAddress;
import com.easybuy.service.BuyCarService;
import com.easybuy.service.OrderDetailService;
import com.easybuy.service.OrderService;
import com.easybuy.service.UserAddressService;
import com.easybuy.service.impl.BuyCarServiceImpl;
import com.easybuy.service.impl.OrderDetailServiceImpl;
import com.easybuy.service.impl.OrderServiceImpl;
import com.easybuy.service.impl.UserAddressServiceImpl;

@WebServlet("/buyCarThreeServlet")
public class BuyCarThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserAddressService userAddressService = new UserAddressServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private BuyCarService buyCarService = new BuyCarServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			User user = (User) session.getAttribute("login");
			//获取用户ID
			int userId = user.getId();
			//获取登录名
			String loginname = user.getLoginname();
			//获取用户地址
			UserAddress useraddress = userAddressService.getUserDefaultAddress(userId);
			//生成创建日期
			Date createtime = new Date();
			//获取总花费
			Float cost = Float.parseFloat(request.getParameter("cost"));
			//订单状态初始为未审核
			int status = 0;
			
			//生成订单号(根据当前时间加上用户id生成,确保不重复)
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String serialnumber = sdf.format(createtime)+userId;
			
			//创建Order对象并赋值
			Order order = new Order();
			order.setUserid(userId);
			order.setLoginname(loginname);
			order.setUseraddress(useraddress.getAddress());
			order.setCreatetime(createtime);
			order.setCost(cost);
			order.setType(1);
			order.setStatus(status);
			order.setSerialnumber(serialnumber);
			List<BuyCar> buycarList = buyCarService.getBuyCar(userId);
			orderService.addOrderAndDetail(order, buycarList);
			//清空购物车
			buycarList.clear();
			request.setAttribute("useraddress", useraddress);
			request.setAttribute("serialnumber", serialnumber);
			request.setAttribute("cost", cost);
			request.getRequestDispatcher("BuyCar_Three.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
