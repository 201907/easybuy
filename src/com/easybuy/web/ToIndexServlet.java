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

import com.easybuy.bean.News;
import com.easybuy.bean.ProductCategory;
import com.easybuy.service.NewsService;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.impl.NewsServiceImpl;
import com.easybuy.service.impl.ProductCategoryServiceImpl;

@WebServlet("/toIndex")
public class ToIndexServlet extends HttpServlet{
	private ProductCategoryService categoryService = new ProductCategoryServiceImpl();
	private NewsService NewsService = new NewsServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		//获取参数
		String data = req.getParameter("data");
		//会话
		HttpSession session = req.getSession();

		//获取新闻
		List<News> news = NewsService.queryNews();
		req.setAttribute("news", news);
		
		//获取一级分类
		List<ProductCategory> epc_first = categoryService.queryProductCategoryByType(1);
		session.setAttribute("epc_first", epc_first);
		//获取二级分类
		List<ProductCategory> epc_second = categoryService.queryProductCategoryByType(2);
		session.setAttribute("epc_second", epc_second);				
		//获取三级分类
		List<ProductCategory> epc_third = categoryService.queryProductCategoryByType(3);
		session.setAttribute("epc_third", epc_third);
		req.getRequestDispatcher("Index.jsp").forward(req, resp);
		

		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
