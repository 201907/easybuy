package com.easybuy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.easybuy.bean.BuyCar;

public interface BuyCarService {
	/**
	 * 添加购物车
	 * @param buycar
	 * @return
	 * @throws ExecutionException 
	 * @throws SQLException
	 */
	boolean addBuyCar(int userId,BuyCar buycar) throws ExecutionException;
	/**
	 * 删除购物车
	 * @param id
	 * @return
	 * @throws ExecutionException 
	 */
	int deleteBuyCar(int userId,long id) throws ExecutionException;
	/**
	 * 获得购物车总价
	 * @return
	 */
	float getSumPrice(int userId) throws ExecutionException;
	/**
	 * 获得用户购物车
	 * @param userId
	 * @return
	 * @throws ExecutionException
	 */
	List<BuyCar> getBuyCar(int userId)throws ExecutionException;
	/**
	 * 获得购物车产品总数
	 * @param userId
	 * @return
	 * @throws ExecutionException
	 */
	int getProductCount(int userId)throws ExecutionException;
	/**
	 * 更新产品数量
	 * @param userId
	 * @param buyCarId
	 * @param count
	 * @return
	 * @throws ExecutionException
	 */
	int updateProductCount(int userId,long buyCarId,int count)throws ExecutionException;
}
