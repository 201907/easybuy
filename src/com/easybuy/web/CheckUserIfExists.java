package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;

@WebServlet("/checkUserIfExists")
public class CheckUserIfExists extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if(userService.userifexistsByUserName(username)!=null) {
			resp.getWriter().print("false");
		}else {
			resp.getWriter().print("true");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
