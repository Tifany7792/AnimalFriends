package es.codeurjc.AnimalFriendsDad.Repositorios;

import es.codeurjc.AnimalFriendsDad.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProductos extends JpaRepository<Productos,Long>{

}
