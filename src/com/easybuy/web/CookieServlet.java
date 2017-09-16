package com.easybuy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String uname=null;
		String upwd=null;
		Cookie[] cookies=request.getCookies();
		for(Cookie li:cookies) {
			if(li.getName().equals("user")) {
				uname=li.getValue();
			}
			else if(li.getName().equals("pwd")) {
				upwd=li.getValue();
			}
		}
		session.setAttribute("uname", uname);
		session.setAttribute("upwd", upwd);
		response.sendRedirect("easybuypages/Login.jsp");
	}

}
