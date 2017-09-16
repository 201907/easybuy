package com.easybuy.service;

import java.util.List;

import com.easybuy.bean.News;

public interface NewsService {
	/**
	 * 查询所有的新闻
	 * @return
	 */
	List<News> queryNews();
	/**
	 * 分页查询
	 * @param start
	 * @param rowCount
	 * @return
	 */
	List<News> queryNewsByPage(int index,int rowCount);
	/**
	 * 获得新闻的总记录数
	 * @return
	 */
	int getNewsCount();
}
