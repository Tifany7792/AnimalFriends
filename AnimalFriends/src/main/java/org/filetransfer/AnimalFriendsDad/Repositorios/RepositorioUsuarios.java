package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;

import org.filetransfer.AnimalFriendsDad.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long>{
	

	List<Usuarios> findByNombre(String nombre);
	List<Usuarios> findByPasword(String pasword);
}
