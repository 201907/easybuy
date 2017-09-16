package com.easybuy.dao.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.easybuy.bean.BuyCar;
import com.easybuy.dao.BuyCarDao;
import com.easybuy.utils.BuyCarCacheLoader;
import com.easybuy.utils.DBManager;
import com.easybuy.utils.GuavaCache;

public class BuyCarDaoImpl implements BuyCarDao{
	//guava缓存的工具类保存购物车数据
	private GuavaCache<Integer, List<BuyCar>> buycarCache = GuavaCache.getInstance(new BuyCarCacheLoader(DBManager.getInstance()));
	
	@Override
	public boolean addBuyCar(int userId,BuyCar buycar) throws ExecutionException {
		List<BuyCar> buyCarList = buycarCache.get(userId);
		return buyCarList.add(buycar);
	}

	@Override
	public int deleteBuyCar(int userId,long buyCarId) throws ExecutionException {
		List<BuyCar> buyCarList = buycarCache.get(userId);
		for(int i=0;i<buyCarList.size();i++) {
			if(buyCarList.get(i).getId()==buyCarId) {
				buyCarList.remove(i);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public float getSumPrice(int userId) throws ExecutionException {
		List<BuyCar> buyCarList = buycarCache.get(userId);
		int total = 0;
		for(BuyCar b : buyCarList) {
			total += b.getProduct().getPrice()*b.getCount();
		}
		return total;
	}

	@Override
	public List<BuyCar> getBuyCar(int userId) throws ExecutionException {
		// TODO Auto-generated method stub
		return buycarCache.get(userId);
	}

	@Override
	public int getProductCount(int userId) throws ExecutionException {
		List<BuyCar> buyCarList = buycarCache.get(userId);
		int count = 0;
		for(BuyCar b : buyCarList) {
			count += b.getCount();
		}
		return count;
	}

	@Override
	public int updateProductCount(int userId, long buyCarId, int count) throws ExecutionException {
		List<BuyCar> buyCarList = buycarCache.get(userId);
		//遍历购物车并更新
		for(BuyCar c : buyCarList) {
			if(c.getId()==buyCarId) {
				c.setCount(count);
				return 1;
			}
		}
		return 0;
	}



}
