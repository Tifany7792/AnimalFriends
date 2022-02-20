package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLocalizaciones extends JpaRepository<Localizaciones, Long> {
	Optional<Localizaciones> findByTipo(String tipo);

	Optional<Localizaciones> findByNombreSitio(String nombre);

	Optional<Localizaciones> findById(Long id);

}