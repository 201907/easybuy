package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.News;

public interface NewsDao  {
	/**
	 * 查询所有的新闻
	 * @return
	 */
	List<News> queryNews(Connection conn) throws SQLException;
	/**
	 * 新闻分页
	 * @param conn
	 * @param 起始页
	 * @param 每页有多少数据
	 * @return
	 * @throws SQLException
	 */
	List<News> queryNewsByPage(Connection conn,int index,int rowCount) throws SQLException;
	/**
	 * 获得总记录数
	 * @param conn
	 * @return
	 */
	int getNewsCount(Connection conn) throws SQLException;
}
