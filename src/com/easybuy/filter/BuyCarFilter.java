package com.easybuy.filter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.User;
import com.easybuy.service.BuyCarService;
import com.easybuy.service.impl.BuyCarServiceImpl;

/**
 * 购物车拦截器 让每个页面都返回购物车数据
 * @author Administrator
 *
 */
@WebFilter("/*")
public class BuyCarFilter implements Filter{
	private BuyCarService buyCarService = new BuyCarServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)arg0).getSession();
		User user = (User)session.getAttribute("login");
		if(user!=null) {
			int userId = user.getId();
			try {
				List<BuyCar>buyCarList = buyCarService.getBuyCar(userId);
				float total = buyCarService.getSumPrice(userId);
				arg0.setAttribute("buycarTotal", total);
				arg0.setAttribute("buycar", buyCarList);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
