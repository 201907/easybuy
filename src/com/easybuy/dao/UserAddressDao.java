package com.easybuy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.UserAddress;

public interface UserAddressDao {
	/**
	 * 取消默认地址
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int cancelUserDefaultAddress(Connection conn,int id) throws SQLException;
	/**
	 * 设置为默认地址
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int setUserDefaultAddress(Connection conn,int id) throws SQLException;
	/**
	 * 添加用户地址
	 * @param conn
	 * @param userAddress
	 * @return
	 */
	int addUserAddress(Connection conn,UserAddress userAddress) throws SQLException;
	/**
	 * 根据用户id查询对应的所有用户地址
	 * @param id
	 * @return
	 */
	List<UserAddress> queryAddressByUserId(Connection conn,int userId) throws SQLException;
	/**
	 * 根据用户ID获取用户的默认地址
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	UserAddress getUserDefaultAddress(Connection conn,int userId) throws SQLException;
	/**
	 * 获得用户地址的数量
	 * @param conn
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	int getUserAddressCount(Connection conn,int userId) throws SQLException;
	/**
	 * 分页
	 * @param conn
	 * @param 第几页
	 * @param 数据的条数
	 * @return
	 */
	List<UserAddress>getUserAddressByPage(Connection conn,int index,int count,int userId) throws SQLException;
}
