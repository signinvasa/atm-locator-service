package com.mobiquity.atmlocator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;


/**
 * Cache service class that contians method to invalidate the cache every 1 hour
 * 
 * @author Madanmohan Vasa
 */
@Service
public class AtmLocatorCacheService {

	public static final String ATM_INFO_CACHE = "atmInformation";

	@Autowired
	CacheManager cacheManager;

	/**
	 * Scheduler that invokes this method for every 1 hour to clear the cache
	 */
	@Scheduled(fixedRate = (6000000))
	public void refreshCache() {
		cacheManager.getCache(ATM_INFO_CACHE).clear();
	}

}
