package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
import com.easybuy.utils.MD5Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//登录
		if(request.getParameter("data").equals("login")) {
			try{
				String loginname = request.getParameter("uname");
				String password = MD5Util.encodeStr(request.getParameter("upwd"));
				String[] autoLogin=request.getParameterValues("autoLogin");
				User user = userService.userifexistsByUserNameAndPwd(loginname, password);
				if(user == null){
					out.println("<script type='text/javascript'>"
							+ "alert('用户名或密码错误，请重新登录');"
							+ "open('Login.jsp','_self');"
							+ "</script>");
				}else {
					session.setAttribute("login", user);
					//如果勾选了自动登录保存cookie
					if(autoLogin != null) {
						Cookie uname = new Cookie("user",loginname);
						uname.setMaxAge(60*60*24*7);
						response.addCookie(uname);
						Cookie upwd = new Cookie("pwd",password);
						upwd.setMaxAge(60*60*24*7);
						response.addCookie(upwd);
					}
					out.println("<script type='text/javascript'>"
							+ "alert('登录成功！');"
							+ "open('toIndex','_self');"
							+ "</script>");

				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//登出
		else if(request.getParameter("data").equals("logout")) {
			Cookie[] cookies=request.getCookies();
			for(Cookie li:cookies) {
				if(li.getName().equals("user")||li.getName().equals("pwd")) {
					li.setMaxAge(0);
					response.addCookie(li);
				}
			}
			session.setAttribute("login", null);
			out.println("<script type='text/javascript'>"
						+ "alert('注销成功');"
						+ "open('toIndex','_self');"
						+ "</script>");

		}
		out.flush();
		out.close();
	}
}
