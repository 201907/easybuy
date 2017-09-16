package com.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.Order;
import com.easybuy.bean.UserAddress;
import com.easybuy.dao.UserAddressDao;
import com.easybuy.utils.DBManager;
import com.google.common.collect.Lists;

public class UserAddressDaoImpl implements UserAddressDao {
	/**
	 * 根据用户id查询用户的默认地址
	 */
	@Override
	public UserAddress getUserDefaultAddress(Connection conn, int userId) throws SQLException {
		UserAddress userAddress = null;
		try(PreparedStatement ps = conn.prepareStatement("select * from easybuy_user_address where userId = ? and isDefault = 1")){
			ps.setInt(1, userId);
			try(ResultSet rs=ps.executeQuery()){
				if(rs.next()) {
					userAddress = new UserAddress();
					userAddress.setId(rs.getInt("id"));
					userAddress.setAddress(rs.getString("address"));
					userAddress.setCreatetime(rs.getDate("createtime"));
					userAddress.setUserId(rs.getInt("userId"));
					userAddress.setReceiver(rs.getString("receiver"));
					userAddress.setIsDefault(rs.getInt("isDefault"));
					userAddress.setRemark(rs.getString("remark"));
					userAddress.setArea(rs.getString("area"));
					userAddress.setMobile(rs.getString("mobile"));
					userAddress.setPostcodes(rs.getString("postcodes"));
					userAddress.setEmail(rs.getString("email"));
				}
			}
		}
		return userAddress;
	}
	
	/**
	 * 查询用户的所有地址
	 */
	@Override
	public List<UserAddress> queryAddressByUserId(Connection conn, int userId) throws SQLException {
		List<UserAddress> userAddressList = null;
		try(PreparedStatement ps=conn.prepareStatement("select * from easybuy_user_address where userId = ?")){
			ps.setObject(1,userId);
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					if(userAddressList==null)userAddressList=Lists.newArrayList();
					UserAddress userAddress = new UserAddress();
					userAddress.setId(rs.getInt("id"));
					userAddress.setAddress(rs.getString("address"));
					userAddress.setCreatetime(rs.getDate("createtime"));
					userAddress.setUserId(rs.getInt("userId"));
					userAddress.setReceiver(rs.getString("receiver"));
					userAddress.setIsDefault(rs.getInt("isDefault"));
					userAddress.setRemark(rs.getString("remark"));
					userAddress.setArea(rs.getString("area"));
					userAddress.setMobile(rs.getString("mobile"));
					userAddress.setPostcodes(rs.getString("postcodes"));
					userAddress.setEmail(rs.getString("email"));
					userAddressList.add(userAddress);
				}
			}
		}
		return userAddressList;
	}
	/**
	 * 获得用户地址的数量
	 * @param conn
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int getUserAddressCount(Connection conn, int userId) throws SQLException {
		int result = 0;
		try(
			PreparedStatement ps=conn.prepareStatement("select count(*) from easybuy_user_address where userId = ?")){
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}
		return result;
	}

	@Override
	public int addUserAddress(Connection conn, UserAddress userAddress)  throws SQLException{
		int result = 0;
		try(PreparedStatement ps=conn.prepareStatement("insert into easybuy_user_address values (id,?,?,?,?,?,?,now(),?,?,?)")){
			ps.setString(1, userAddress.getArea());
			ps.setString(2, userAddress.getReceiver());
			ps.setString(3, userAddress.getMobile());
			ps.setString(4, userAddress.getPostcodes());
			ps.setString(5, userAddress.getEmail());
			ps.setString(6, userAddress.getAddress());
			ps.setInt(7, userAddress.getUserId());
			ps.setInt(8, userAddress.getIsDefault());
			ps.setString(9, userAddress.getRemark());
			result = ps.executeUpdate();
		}
		return result;
	}
	/**
	 * 分页
	 * @param conn
	 * @param 第几页
	 * @param 数据的条数
	 * @return
	 */
	@Override
	public List<UserAddress> getUserAddressByPage(Connection conn, int index, int count,int userId) throws SQLException {
		List<UserAddress> userAddressList = null;
		int start = count*(index-1);//起始位置
		try(PreparedStatement ps = conn.prepareStatement("select * from easybuy_user_address where userId = ? limit ?,?")){
			ps.setInt(1, userId);
			ps.setInt(2, start);
			ps.setInt(3, count);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					if(userAddressList==null)userAddressList=Lists.newArrayList();
					UserAddress userAddress = new UserAddress();
					userAddress.setId(rs.getInt("id"));
					userAddress.setAddress(rs.getString("address"));
					userAddress.setCreatetime(rs.getDate("createtime"));
					userAddress.setUserId(rs.getInt("userId"));
					userAddress.setReceiver(rs.getString("receiver"));
					userAddress.setIsDefault(rs.getInt("isDefault"));
					userAddress.setRemark(rs.getString("remark"));
					userAddress.setArea(rs.getString("area"));
					userAddress.setMobile(rs.getString("mobile"));
					userAddress.setPostcodes(rs.getString("postcodes"));
					userAddress.setEmail(rs.getString("email"));
					userAddressList.add(userAddress);
				}
			}
		}
		return userAddressList;
	}
	/**
	 * 设置默认地址
	 */
	@Override
	public int setUserDefaultAddress(Connection conn, int id) throws SQLException {
		try(PreparedStatement ps=conn.prepareStatement("update easybuy_user_address set isDefault = 1 where id = ?")){
			ps.setInt(1, id);
			return ps.executeUpdate();
		}
	}
	/**
	 * 取消默认地址
	 */
	@Override
	public int cancelUserDefaultAddress(Connection conn, int id) throws SQLException {
		try(PreparedStatement ps=conn.prepareStatement("update easybuy_user_address set isDefault = 0 where id = ?")){
			ps.setInt(1, id);
			return ps.executeUpdate();
		}
	}
}
