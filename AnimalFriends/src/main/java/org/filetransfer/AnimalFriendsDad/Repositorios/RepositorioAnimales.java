package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="animales")
public interface RepositorioAnimales extends JpaRepository<Animal, Long>{
	
	@CacheEvict(allEntries=true)
	Animal save(Animal animal);
	
	@CachePut
	Optional<Animal> findByTipo(String tipo);
	@CachePut
	Optional<Animal> findById(Long id);
	
	@CachePut
	List<Animal> findAll();
	
	
}
