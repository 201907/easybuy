package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.easybuy.bean.User;
import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.service.UserService;
import com.easybuy.utils.DBManager;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	private DBManager dbMananger = DBManager.getInstance();

	@Override
	public int addUser(User user) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbMananger.getConn();
			result = userDao.addUser(conn, user);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public User userifexistsByUserName(String username) {
		Connection conn = null;
		User user = null;
		try {
			conn = dbMananger.getConn();
			user = userDao.userifexistsByUserName(conn, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public User userifexistsByUserNameAndPwd(String username, String password) {
		User user = null;
		Connection conn = null;
		try {
			conn = dbMananger.getConn();
			user = userDao.userifexistsByUserNameAndPwd(conn, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	


}
