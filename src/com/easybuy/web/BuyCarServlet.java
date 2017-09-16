package com.easybuy.web;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.User;
import com.easybuy.utils.BuyCarCacheLoader;
import com.easybuy.utils.DBManager;
import com.easybuy.utils.GuavaCache;

@WebServlet("/buyCarServlet")
public class BuyCarServlet extends HttpServlet{
	//guava缓存工具类
	private GuavaCache<Integer, List<BuyCar>> buycarCache = GuavaCache.getInstance(new BuyCarCacheLoader(DBManager.getInstance()));
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//准备数据跳转到BuyCar.jsp
		int userId = ((User)req.getSession().getAttribute("login")).getId();
		List<BuyCar> buyCarList = null;
		try {
			//获取指定用户的购物车
			buyCarList = buycarCache.get(userId);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("buycar",buyCarList);
		req.getRequestDispatcher("BuyCar.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
