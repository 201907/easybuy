package com.easybuy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String referer = ((HttpServletRequest)arg0).getHeader("referer");
		HttpSession session = ((HttpServletRequest)arg0).getSession();
		//防盗链
		if(referer!=null&&!referer.startsWith("http://localhost")) {
			((HttpServletResponse)arg1).sendRedirect("Toindex");
		}
		if(session.getAttribute("login")==null) {//判断用户是否登录
			arg1.setContentType("text/html;charset=utf-8");
			((HttpServletResponse)arg1).getWriter().println("<script>alert('很抱歉您还没有登录');location.href='Login.jsp'</script>");
		}else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
