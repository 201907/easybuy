package com.easybuy.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.easybuy.bean.BuyCar;
import com.easybuy.dao.BuyCarDao;
import com.easybuy.dao.impl.BuyCarDaoImpl;
import com.easybuy.service.BuyCarService;

public class BuyCarServiceImpl implements BuyCarService {
	private BuyCarDao buyCarDao = new BuyCarDaoImpl();
	@Override
	public boolean addBuyCar(int userId, BuyCar buycar) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.addBuyCar(userId, buycar);
	}

	@Override
	public int deleteBuyCar(int userId, long id) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.deleteBuyCar(userId, id);
	}

	@Override
	public float getSumPrice(int userId) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.getSumPrice(userId);
	}

	@Override
	public List<BuyCar> getBuyCar(int userId) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.getBuyCar(userId);
	}

	@Override
	public int getProductCount(int userId) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.getProductCount(userId);
	}

	@Override
	public int updateProductCount(int userId, long buyCarId, int count) throws ExecutionException {
		// TODO Auto-generated method stub
		return buyCarDao.updateProductCount(userId, buyCarId, count);
	}

	
}
