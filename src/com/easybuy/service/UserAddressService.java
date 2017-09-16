package com.easybuy.service;

import java.sql.Connection;
import java.util.List;

import com.easybuy.bean.UserAddress;

public interface UserAddressService {
	/**
	 * 根据用户id查询对应的所有用户地址
	 * @param id
	 * @return
	 */
	List<UserAddress> queryAddressByUserId(int userId);
	/**
	 * 给指定的用户设置默认地址
	 * @param id
	 * @param addressId
	 * @return
	 */
	int setDefaultAddress(int userId,int id);
	/**
	 * 获取用户的默认地址 
	 * @param userId
	 * @return
	 */
	UserAddress getUserDefaultAddress(int userId);
	/**
	 * 获得用户地址的数量
	 * @param userId
	 * @return
	 */
	int getUserAddressCount(int userId);
	/**
	 * 添加用户地址
	 * @param userAddress
	 * @return
	 */
	int addUserAddress(UserAddress userAddress);
	/**
	 * 分页查询指定用户的地址
	 * @param index
	 * @param count
	 * @param userId
	 * @return
	 */
	List<UserAddress> getUserAddressByPage(int index, int count,int userId);
}
