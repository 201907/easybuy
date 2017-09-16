package com.easybuy.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.News;
import com.easybuy.bean.UserAddress;
import com.easybuy.dao.NewsDao;
import com.easybuy.utils.DBManager;
import com.google.common.collect.Lists;

public class NewsDaoImpl implements NewsDao{

	/**
	 * 查询所有新闻
	 */
	@Override
	public List<News> queryNews(Connection conn) throws SQLException {
		List<News> newsList = null;
		//try with resource 自动关闭
		try(
			PreparedStatement ps=conn.prepareStatement("select * from easybuy_news");
			ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				if(newsList==null)newsList=Lists.newArrayList();
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setCreatetime(rs.getDate("createTime"));
				newsList.add(news);
			}
		}
		return newsList;
	}
	/**
	 * 新闻分页
	 */
	@Override
	public List<News> queryNewsByPage(Connection conn, int index, int rowCount) throws SQLException {
		List<News> newsList = null;
		int start = rowCount*(index-1);//起始位置
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_news limit ?,?")){
			ps.setInt(1, start);
			ps.setInt(2, rowCount);
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					if(newsList==null)newsList=Lists.newArrayList();
					News news = new News();
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setContent(rs.getString("content"));
					news.setCreatetime(rs.getDate("createTime"));
					newsList.add(news);
				}
			}
		}
		return newsList;
	}
	/**
	 * 获得新闻的总记录数
	 */
	@Override
	public int getNewsCount(Connection conn) throws SQLException{
		int result = 0;
		try(
				PreparedStatement ps=conn.prepareStatement("select count(*) from easybuy_news");
				ResultSet rs = ps.executeQuery();
			)
		{
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}
		return result;
	}
	

}
