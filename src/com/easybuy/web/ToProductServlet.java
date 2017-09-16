package com.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.bean.Product;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;

@WebServlet("/toProductServlet")
public class ToProductServlet extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();
	private ProductCategoryService categoryService = new ProductCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//out处理
		PrintWriter out=response.getWriter();
		//中文处理
		request.setCharacterEncoding("utf-8");
		//获取id
		int id=Integer.parseInt(request.getParameter("id"));
		//查询
		Product product = productService.queryProductById(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("Product.jsp").forward(request, response);
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
