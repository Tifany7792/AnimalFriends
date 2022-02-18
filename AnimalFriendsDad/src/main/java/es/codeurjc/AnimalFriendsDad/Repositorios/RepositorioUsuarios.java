package es.codeurjc.AnimalFriendsDad.Repositorios;

import java.util.List;

import es.codeurjc.AnimalFriendsDad.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long>{
	

	//List<Usuarios> findByNombre(String nombre);
	//List<Usuarios> findByPasword(String pasword);
	Usuarios findByNombre(String nombre);
}
