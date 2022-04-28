package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.repository.CrudRepository;

@CacheConfig(cacheNames="usuarios")
public interface RepositorioUsuarios extends CrudRepository <Usuarios, Long> {

	
	@CachePut
	public Optional<Usuarios> findByNombre(String nombre);
	//public Usuarios findByNombre(String nombre);
	
	@CachePut
	public Optional<Usuarios> findById(Long id);
	
	@CachePut
	public List<Localizaciones> findByReservasNombreSitio(Long id);
	
	@CachePut
	public List<Animal> findByMascotasTipo(Long id);
	
	@CachePut
	public List<Productos> findByListaCompraNombre(Long id);
	
	@CachePut
	public Usuarios findByCorreo(String email);
	
	@CachePut
	List<Usuarios> findAll();
}
