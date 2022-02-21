package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProductos extends JpaRepository<Productos,Long>{
	Optional<Productos> findByTipo(String tipo);
	Optional<Productos> findById(Long id);
	Optional<Productos> findByNombre(String nombre);
}
