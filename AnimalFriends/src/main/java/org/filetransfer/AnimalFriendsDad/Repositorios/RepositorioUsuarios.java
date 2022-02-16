package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long>{
	

	List<Usuarios> findByNombre(String nombre);
	//List<Usuarios> findByPasword(String pasword);
	Usuarios findByNombre1(String nombre);
}
