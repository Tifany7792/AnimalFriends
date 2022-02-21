package org.filetransfer.AnimalFriendsDad.Repositorios;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuarios, Long> {

	public Optional<Usuarios> findByNombre(String nombre);

	public Optional<Usuarios> findById(Long id);
	
	public List<Localizaciones> findByReservasNombreSitio(Long id);
	
	public List<Animal> findByMascotasTipo(Long id);
	
	public List<Productos> findByListaCompraNombre(Long id);
}
