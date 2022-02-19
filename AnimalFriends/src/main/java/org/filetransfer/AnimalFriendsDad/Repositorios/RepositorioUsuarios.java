package org.filetransfer.AnimalFriendsDad.Repositorios;


import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long>{
	

	List<Usuarios> findByNombre(String nombre);
	//List<Usuarios> findByPasword(String pasword);
	//Usuarios findByNombre(String nombre);
}
