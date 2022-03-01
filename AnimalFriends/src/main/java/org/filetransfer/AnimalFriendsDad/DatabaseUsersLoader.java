package org.filetransfer.AnimalFriendsDad;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {
	
	@Autowired
	private RepositorioUsuarios usuarios;
	
	@PostConstruct
	private void initDatabase() {
		usuarios.save(new Usuarios("user","pass","ROLE_USER"));
		usuarios.save(new Usuarios("admin","adminpass","ROLE_USER","ROLE_ADMIN"));
	}
}
