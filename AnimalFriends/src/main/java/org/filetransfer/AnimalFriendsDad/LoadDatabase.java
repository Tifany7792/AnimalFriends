package org.filetransfer.AnimalFriendsDad;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initDatabase(RepositorioUsuarios repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Usuarios("pepe", "pass","ROLE_USER")));
	      log.info("Preloading " + repository.save(new Usuarios("user1", "pass","ROLE_USER")));
	    };
	  }
}
