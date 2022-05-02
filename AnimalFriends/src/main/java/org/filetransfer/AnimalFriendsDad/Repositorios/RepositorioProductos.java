package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@CacheConfig(cacheNames="productos")
public interface RepositorioProductos extends JpaRepository<Productos,Long>{
	
	//	@CacheEvict(allEntries=true)
	Productos save(Productos producto);
	
	//	@CachePut
	Optional<Productos> findByTipo(String tipo);
	//	@CachePut
	Optional<Productos> findById(Long id);
	//	@CachePut
	Optional<Productos> findByNombre(String nombre);
	
	//	@CachePut
	List<Productos> findAll();
}
