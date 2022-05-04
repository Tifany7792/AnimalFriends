package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLocalizaciones extends JpaRepository<Localizaciones, Long> {
	
	Localizaciones save(Localizaciones localizacion);
	
	Optional<Localizaciones> findByTipo(String tipo);

	Optional<Localizaciones> findByNombreSitio(String nombre);

	Optional<Localizaciones> findById(Long id);
	
	List<Localizaciones> findAll();

}