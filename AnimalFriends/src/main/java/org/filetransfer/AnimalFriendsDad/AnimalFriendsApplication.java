package org.filetransfer.AnimalFriendsDad;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class AnimalFriendsApplication {
	
	private static final Log LOG = LogFactory.getLog(AnimalFriendsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AnimalFriendsApplication.class, args);
		
	}
	
	@Bean
	public CacheManager cacheManager() {
		LOG.info("Activating cache...");
		return new ConcurrentMapCacheManager("animales");
	}
	

}
