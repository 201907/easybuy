package com.easybuy.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
import com.easybuy.utils.MD5Util;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//业务层
	private UserService userService=new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;
		try {
			User user = new User();
			user.setLoginname(request.getParameter("username"));
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setMobile(request.getParameter("tel"));
			user.setPassword(MD5Util.encodeStr(request.getParameter("pswd")));
			user.setSex("男");
			user.setType(0);
			if(userService.addUser(user)!=0) {
				user = userService.userifexistsByUserNameAndPwd(user.getUsername(), user.getPassword());
				request.getSession().setAttribute("login", user);
				result = "<script>alert('注册成功');location.href='toIndex'</script>";
			}else {
				result = "<script>alert('注册失败');location.href='Regist.jsp'</script>";
			}
		} catch (NoSuchAlgorithmException e) {
			result = "<script>alert('注册失败');location.href='Regist.jsp'</script>";
			e.printStackTrace();
		}
		response.getWriter().println(result);

	}
}
