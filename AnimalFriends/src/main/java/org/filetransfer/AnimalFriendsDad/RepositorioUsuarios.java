package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import javax.persistence.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long>{
	
	List<Usuarios> findByName(String name);
	List<Usuarios> findByPasword(String pasword);
}
