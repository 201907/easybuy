package com.easybuy.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * guava缓存工具类
 * @author Administrator
 * @param <K>
 * @param <V>
 */
public class GuavaCache <K, V>{
	private LoadingCache<K, V> cache = null;
	private static volatile GuavaCache guavaCache = null;
	private GuavaCache(CacheLoader<K, V> cacheLoader) {
		cache = CacheBuilder.
				newBuilder().
				maximumSize(100). 
				expireAfterWrite(10, TimeUnit.MINUTES).
				build(cacheLoader);
	}
	public V get(K k) throws ExecutionException {
		return cache.get(k);
	}
	//双检查锁机制
	public static<K,V> GuavaCache getInstance(CacheLoader<K, V> cacheLoader) {
		if(guavaCache==null) {
			synchronized(GuavaCache.class) {
				if(guavaCache==null) {
					guavaCache = new GuavaCache<>(cacheLoader);
				}
			}
		}
		return guavaCache;
	}
}
