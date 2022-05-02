package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

//@CacheConfig(cacheNames="localizaciones")
public interface RepositorioLocalizaciones extends JpaRepository<Localizaciones, Long> {
	
//	@CacheEvict(allEntries=true)
	Localizaciones save(Localizaciones localizacion);
	
	//	@CachePut
	Optional<Localizaciones> findByTipo(String tipo);

	//	@CachePut
	Optional<Localizaciones> findByNombreSitio(String nombre);

	//	@CachePut
	Optional<Localizaciones> findById(Long id);
	
	//	@CachePut
	List<Localizaciones> findAll();

}