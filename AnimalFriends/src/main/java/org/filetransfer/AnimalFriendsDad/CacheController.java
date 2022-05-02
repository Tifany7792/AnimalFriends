package org.filetransfer.AnimalFriendsDad;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping(value="/cache/animales", method=RequestMethod.GET)
	public Map<Object, Object> getCacheContentA() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("animales");
		return cache.getNativeCache();
	}
	
	@RequestMapping(value="/cache/localizaciones", method=RequestMethod.GET)
	public Map<Object, Object> getCacheContentL() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("localizaciones");
		return cache.getNativeCache();
	}
	
	@RequestMapping(value="/cache/productos", method=RequestMethod.GET)
	public Map<Object, Object> getCacheContentP() {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("productos");
		return cache.getNativeCache();
	}
	
}
