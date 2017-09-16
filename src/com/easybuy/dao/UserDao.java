package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.easybuy.bean.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(Connection conn,User user) throws SQLException;


	/**
	 * 根据用户名判断用户是否存在
	 * @param username
	 * @return
	 */
	User userifexistsByUserName(Connection conn,String username) throws SQLException;


	/**
	 * 根据用户民密码判断用户是否存在
	 * @param conn
	 * @param username
	 * @param password
	 * @return
	 */
	User userifexistsByUserNameAndPwd(Connection conn,String username,String password) throws SQLException;
}
