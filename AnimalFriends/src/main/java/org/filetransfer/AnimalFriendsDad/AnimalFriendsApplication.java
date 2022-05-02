package org.filetransfer.AnimalFriendsDad;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

//@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class AnimalFriendsApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AnimalFriendsApplication.class, args);
		
	}
	
	@Bean
    public Config config() {

        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));

        return config;
    }
	
	//private static final Log LOG = LogFactory.getLog(AnimalFriendsApplication.class);
//	@Bean
//	public CacheManager cacheManager() {
//		LOG.info("Activating cache...");
//		return new ConcurrentMapCacheManager("animales","localizaciones","productos");
//	}
	

}
