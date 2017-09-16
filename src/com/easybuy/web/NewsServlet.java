package com.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.bean.News;
import com.easybuy.service.NewsService;
import com.easybuy.service.impl.NewsServiceImpl;


@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//业务层
	private NewsService newsService = new NewsServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String data = request.getParameter("data");
		//会话
		HttpSession session = request.getSession();
		if(data.equals("paging")){
			//获得当前页码
			int index = Integer.parseInt(request.getParameter("index"));
			//获得总记录数
			int sum = newsService.getNewsCount();
			//设置每页10条数据
			int rowCount = 10;
			//获得最大页
			int max_pag = (sum+rowCount-1)/rowCount;
			List<News> news = newsService.queryNewsByPage(index, rowCount);
			//共享
			request.setAttribute("news", news);
			request.setAttribute("index", index);
			request.setAttribute("max_pag", max_pag);
			//跳转
			request.getRequestDispatcher("Member_News.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
