package com.easybuy.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid连接池
 * 获取连接：DBManager.getInstance().getConn()
 * @author Administrator
 *
 */
public class DBManager {
	private DruidDataSource dataSource;
	public Connection getConn() throws SQLException {
		Connection conn = dataSource.getConnection();
		//关闭自动提交
		conn.setAutoCommit(false);
		return conn;
	}
	public static DBManager getInstance() {
		return Inner.dbManager;
	}
	public static class Inner{
		public final static DBManager dbManager = new DBManager();
	}
	private DBManager() {
		super();
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("DBconfig.properties"));
			dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
