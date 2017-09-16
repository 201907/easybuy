package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easybuy.bean.User;
import com.easybuy.dao.UserDao;
import com.easybuy.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private DBManager dbManger = DBManager.getInstance();
	/**
	 * 根据用户名判断用户是否存在
	 */
	@Override
	public User userifexistsByUserName(Connection conn, String username) throws SQLException {
		User user = null;
		try(PreparedStatement ps = conn.prepareStatement("select * from easybuy_user where loginName = ?")){
			ps.setString(1, username);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					user = new User();
					user.setEmail(rs.getString("email"));
					user.setId(rs.getInt("id"));
					user.setIdentitycode(rs.getString("identitycode"));
					user.setLoginname(rs.getString("loginname"));
					user.setMobile(rs.getString("mobile"));
					user.setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					user.setType(rs.getInt("type"));
					user.setUsername(rs.getString("username"));
				}
			}
		}
		return user;
	}
	@Override
	public int addUser(Connection conn, User user) throws SQLException {
		int result = 0;
		try(PreparedStatement ps=conn.prepareStatement("insert into easybuy_user values (id,?,?,?,?,?,?,?,?)")){
			ps.setString(1, user.getLoginname());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getIdentitycode());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getMobile());
			ps.setObject(8, user.getType());
			result = ps.executeUpdate();
		}
		return result;
	}
	@Override
	public User userifexistsByUserNameAndPwd(Connection conn, String username, String password) throws SQLException {
		User user = null;
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_user where loginName = ? and password = ?")){
			ps.setString(1, username);
			ps.setString(2, password);
			try(ResultSet rs=ps.executeQuery()){
				if(rs.next()) {
					user = new User();
					user.setEmail(rs.getString("email"));
					user.setId(rs.getInt("id"));
					user.setIdentitycode(rs.getString("identitycode"));
					user.setLoginname(rs.getString("loginname"));
					user.setMobile(rs.getString("mobile"));
					user.setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					user.setType(rs.getInt("type"));
					user.setUsername(rs.getString("username"));
				}
			}
		}
		return user;
	}


}
