package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProductos extends JpaRepository<Productos,Long>{
	Optional<Productos> findByTipo(String tipo);
	Optional<Productos> findById(Long id);
	Optional<Productos> findByNombre(String nombre);
}
