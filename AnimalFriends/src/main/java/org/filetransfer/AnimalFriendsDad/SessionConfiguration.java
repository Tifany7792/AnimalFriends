package org.filetransfer.AnimalFriendsDad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSession;
import org.springframework.session.hazelcast.Hazelcast4IndexedSessionRepository;
import org.springframework.session.hazelcast.Hazelcast4PrincipalNameExtractor;
import org.springframework.session.hazelcast.HazelcastSessionSerializer;
import org.springframework.session.hazelcast.config.annotation.SpringSessionHazelcastInstance;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.AttributeConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.IndexConfig;
import com.hazelcast.config.IndexType;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@EnableHazelcastHttpSession
public class SessionConfiguration {
	
	@Bean
	@SpringSessionHazelcastInstance
	public HazelcastInstance hazelcastInstance() {
	    Config config = new Config();
	    config.setClusterName("spring-session-cluster");

	    AttributeConfig attributeConfig = new AttributeConfig()
	            .setName(Hazelcast4IndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
	            .setExtractorClassName(Hazelcast4PrincipalNameExtractor.class.getName());

	    config.getMapConfig("127.0.0.1")
	            .addAttributeConfig(attributeConfig).addIndexConfig(
	            new IndexConfig(IndexType.HASH, Hazelcast4IndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE));

	    SerializerConfig serializerConfig = new SerializerConfig();
	    serializerConfig.setImplementation(new HazelcastSessionSerializer()).setTypeClass(MapSession.class);
	    config.getSerializationConfig().addSerializerConfig(serializerConfig);

	    return Hazelcast.newHazelcastInstance(config);
	}
}

