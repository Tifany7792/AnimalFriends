package org.filetransfer.AnimalFriendsDad;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class DatabaseUsersLoader {

	@Autowired
	private RepositorioUsuarios usuarios;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerFactory.getLogger(DatabaseUsersLoader.class);

	@Bean
	CommandLineRunner initDatabase(RepositorioUsuarios repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Usuarios("user", passwordEncoder.encode("pass"), "USER")));
			log.info("Preloading " + repository.save(new Usuarios("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN")));
		};
	}
/*
	@PostConstruct
	private void init() {
		// usuarios.save(new Usuarios("user","pass","ROLE_USER"));
		// usuarios.save(new Usuarios("admin","adminpass","ROLE_USER","ROLE_ADMIN"));
		usuarios.save(new Usuarios("user", passwordEncoder.encode("pass"), "USER"));
		usuarios.save(new Usuarios("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));

	}*/
}
