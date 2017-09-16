package com.easybuy.utils;

import java.util.ArrayList;
import java.util.List;

import com.easybuy.bean.BuyCar;
import com.google.common.cache.CacheLoader;

public class BuyCarCacheLoader extends CacheLoader<Integer, List<BuyCar>>{
	private DBManager dbManager;
	public BuyCarCacheLoader(DBManager dbManager) {
		super();
		this.dbManager = dbManager;
	}
	
	@Override
	public List<BuyCar> load(Integer arg0) throws Exception {
		return new ArrayList<BuyCar>();
	}
}
