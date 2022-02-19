package org.filetransfer.AnimalFriendsDad;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
public class AnimalFriendsApplication {

	@Autowired
	private Environment env;
	
	private static final Log LOG = LogFactory.getLog(AnimalFriendsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AnimalFriendsApplication.class, args);
		
	}

}
