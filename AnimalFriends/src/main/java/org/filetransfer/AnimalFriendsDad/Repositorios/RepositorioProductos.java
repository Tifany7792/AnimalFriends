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
public interface RepositorioProductos extends JpaRepository<Productos,Long>{
	
	Productos save(Productos producto);
	

	Optional<Productos> findByTipo(String tipo);

	Optional<Productos> findById(Long id);

	Optional<Productos> findByNombre(String nombre);
	List<Productos> findAll();
}
