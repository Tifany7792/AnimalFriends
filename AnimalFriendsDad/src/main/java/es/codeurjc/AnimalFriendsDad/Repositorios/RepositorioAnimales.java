package es.codeurjc.AnimalFriendsDad.Repositorios;

import es.codeurjc.AnimalFriendsDad.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAnimales extends JpaRepository<Animal, Long>{
	
	
	
}
