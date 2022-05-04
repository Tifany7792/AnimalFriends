package org.filetransfer.AnimalFriendsDad;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CacheController {

	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping("/cache")
	public String getCacheContent(Model model) {
		ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("animales");
		model.addAttribute("cache",cache.getNativeCache().toString());
		return "cache";
	}
	
}
