package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.PageInfo;
import com.easybuy.bean.User;
import com.easybuy.bean.UserAddress;
import com.easybuy.service.UserAddressService;
import com.easybuy.service.impl.UserAddressServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class MemberAddressServlet
 */
@WebServlet("/memberAddressServlet")
public class MemberAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //业务层
	private UserAddressService uas =new UserAddressServiceImpl();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();;	
		//取出页码
		int index = Integer.valueOf(request.getParameter("index"));
		//取出用户ID
		int userId = ((User)session.getAttribute("login")).getId();
		//获取用户地址的数量
		int pageCount = uas.getUserAddressCount(userId);
		//获取总共的页码数
		int rowCount = pageCount==0?0:(pageCount+1-1)/pageCount; 
		List<UserAddress> userAddressList = uas.getUserAddressByPage(index, 1, userId);
		PageInfo<UserAddress> pageInfo = PageInfo.valueOfPageInfo(pageCount, index, userAddressList);
		Gson gson = new Gson();
		if(userAddressList==null) {//没有数据
			pageInfo.setSuccess(false);
			String json = gson.toJson(pageInfo);
			response.getWriter().println(json);
		}else {
			pageInfo.setSuccess(true);
			String json = gson.toJson(pageInfo);
			response.getWriter().println(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
