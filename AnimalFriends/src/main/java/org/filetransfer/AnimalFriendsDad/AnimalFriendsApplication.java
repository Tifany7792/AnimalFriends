package org.filetransfer.AnimalFriendsDad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class AnimalFriendsApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AnimalFriendsApplication.class, args);
		
	}

	
	private static final Log LOG = LogFactory.getLog(AnimalFriendsApplication.class);
	@Bean
	public CacheManager cacheManager() {
		LOG.info("Activating cache...");
		return new ConcurrentMapCacheManager("animales");
	}
	

}
