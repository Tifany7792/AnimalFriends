package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuarios, Long> {

	Optional<Usuarios> findByNombre(String nombre);

	Optional<Usuarios> findById(Long id);
}
