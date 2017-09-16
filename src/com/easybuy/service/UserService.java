package com.easybuy.service;


import java.sql.Connection;

import com.easybuy.bean.User;

public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 根据用户名判断用户是否存在
	 * @param username
	 * @return
	 */
	User userifexistsByUserName(String username);
	/**
	 * 根据用户名密码判断用户是否存在
	 * @param username
	 * @param password
	 * @return
	 */
	User userifexistsByUserNameAndPwd(String username,String password);
}
