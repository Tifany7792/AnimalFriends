package org.filetransfer.AnimalFriendsDad;


import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataBaseUsage implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		

	}	
	
	@Autowired
	private RepositorioUsuarios repository;
	
	@PostConstruct
	public void init() {

		repository.save(new Usuarios("Estefania","771992"));
		repository.save(new Usuarios("Pepito","1264984"));
		
		//List<Usuarios> bauers = repository.findByNombre("Estefania");
		/*for (Usuarios bauer : bauers) {
			System.out.println(bauer);
		}*/
		
		//repository.delete(bauers.get(0));
	}
}
