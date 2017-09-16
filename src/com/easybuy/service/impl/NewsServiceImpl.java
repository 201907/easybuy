package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.News;
import com.easybuy.dao.NewsDao;
import com.easybuy.dao.impl.NewsDaoImpl;
import com.easybuy.service.NewsService;
import com.easybuy.utils.DBManager;

public class NewsServiceImpl implements NewsService {
	private DBManager dbManager = DBManager.getInstance();
	private NewsDao newsDao = new NewsDaoImpl();
	/**
	 * 查询所有新闻
	 */
	@Override
	public List<News> queryNews() {
		List<News> newsList = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			newsList = newsDao.queryNews(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return newsList;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<News> queryNewsByPage(int index, int rowCount) {
		Connection conn = null;
		List<News> newsList = null;
		try {
			conn = dbManager.getConn();
			newsList = newsDao.queryNewsByPage(conn, index, rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return newsList;
	}
	/**
	 * 获得总记录数
	 */
	@Override
	public int getNewsCount() {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			result = newsDao.getNewsCount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
