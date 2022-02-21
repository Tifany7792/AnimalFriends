package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAnimales extends JpaRepository<Animal, Long>{
	
	Optional<Animal> findByTipo(String tipo);
	Optional<Animal> findById(Long id);

}
