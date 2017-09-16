package com.easybuy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
/**
 * 拦截所有请求，实现自动登录
 * @author Administrator
 *
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter{
	private UserService userService = new UserServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)arg0).getSession();
		Cookie[]cookies = ((HttpServletRequest)arg0).getCookies();
		String userName = null;
		String pwd = null;
		for(Cookie c:cookies) {
			if(c.getName().equals("user")) {
				userName = c.getValue();
			}else if(c.getName().equals("pwd")) {
				pwd = c.getValue();
			}
		}
		User user = userService.userifexistsByUserNameAndPwd(userName, pwd);
		if(user!=null)session.setAttribute("login", user);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
