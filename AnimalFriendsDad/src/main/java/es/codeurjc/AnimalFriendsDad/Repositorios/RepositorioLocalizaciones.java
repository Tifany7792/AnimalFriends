package es.codeurjc.AnimalFriendsDad.Repositorios;
import java.util.List;

import es.codeurjc.AnimalFriendsDad.entidades.Localizaciones;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioLocalizaciones extends JpaRepository<Localizaciones,Long>{
	
	
}