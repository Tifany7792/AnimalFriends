package org.filetransfer.AnimalFriendsDad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioUsuarios extends CrudRepository<Usuarios,Long>{
	

	List<Usuarios> findByNombre(String nombre);
	//List<Usuarios> findByPasword(String pasword);
}
