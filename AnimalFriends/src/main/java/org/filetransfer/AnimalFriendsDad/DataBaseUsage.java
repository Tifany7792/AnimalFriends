package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataBaseUsage implements CommandLineRunner{

	
	@Autowired
	private RepositorioUsuarios repository;
	
	public void run(String... args) throws Exception{
		repository.save(new Usuarios("Estefania","771992"));
		repository.save(new Usuarios("Pepito","1264984"));
		
		List<Usuarios> bauers = repository.findByNombre("Estefania");
		for (Usuarios bauer : bauers) {
			System.out.println(bauer);
		}
		
		//repository.delete(bauers.get(0));
	}

}
