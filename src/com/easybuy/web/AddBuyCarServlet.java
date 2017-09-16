package com.easybuy.web;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.BuyCar;
import com.easybuy.bean.BuyCarInfo;
import com.easybuy.bean.Product;
import com.easybuy.bean.User;
import com.easybuy.service.BuyCarService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.BuyCarServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;
import com.google.gson.Gson;

@WebServlet("/addBuyCarServlet")
public class AddBuyCarServlet extends HttpServlet{
//	private BuyCarService buyCarService = new BuyCarServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	//guava缓存的工具类保存购物车数据
	private BuyCarService buyCarService = new BuyCarServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Gson gson = new Gson();
		int count = Integer.valueOf(req.getParameter("count"));
		int productId = Integer.valueOf(req.getParameter("id"));
		BuyCarInfo buyCarInfo = new BuyCarInfo();
		User user =  (User)req.getSession().getAttribute("login");
		if(user==null) {
			buyCarInfo.setSuccess(false);
			String str = gson.toJson(buyCarInfo);
			resp.getWriter().println(gson.toJson(buyCarInfo));
		}else {
			int userId = user.getId();
			BuyCar buyCar = new BuyCar();
			//设置购物车的唯一标识
			buyCar.setId(new Date().getTime());
			buyCar.setCount(count);
			//根据产品id查询对应的产品
			Product product = productService.queryProductById(productId);
			buyCar.setProduct(product);
			buyCar.setUserId(userId);
			try {
				buyCarInfo.setSuccess(true);
				//添加购物车
				buyCarService.addBuyCar(userId,buyCar);
				//设置该用户产品的数量
				buyCarInfo.setProductCount(buyCarService.getProductCount(userId));
				//设置所有产品的总价
				buyCarInfo.setTotal(buyCarService.getSumPrice(userId));
				//返回json数据
				resp.getWriter().println(gson.toJson(buyCarInfo));
			} catch (ExecutionException e) {
				e.printStackTrace();
				buyCarInfo.setSuccess(false);
				resp.getWriter().println(gson.toJson(buyCarInfo));
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
