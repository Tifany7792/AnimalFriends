package org.filetransfer.AnimalFriendsDad;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {
	
	@Autowired
	private RepositorioUsuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	private void init() {
		//usuarios.save(new Usuarios("user","pass","ROLE_USER"));
		//usuarios.save(new Usuarios("admin","adminpass","ROLE_USER","ROLE_ADMIN"));
		usuarios.save(new Usuarios("user", passwordEncoder.encode("pass"), "USER"));
		usuarios.save(new Usuarios("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
  
	}
}
