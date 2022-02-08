package org.filetransfer.AnimalFriendsDad;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BBDDusuarios")
public class DataBaseUsage{

	
	@Autowired
	private RepositorioUsuarios repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Usuarios("Estefania","771992"));
		repository.save(new Usuarios("Pepito","1264984"));
	}
	
	@GetMapping("/")
	public String tablon(Model model, Pageable page) {

		model.addAttribute("usuarios", repository.findAll(page));

		return "tablon";
	}

	@PostMapping("/usuario/nuevo")
	public String nuevoAnuncio(Model model, Usuarios usu) {

		repository.save(usu);

		return "usuario_guardado";

	}

	@GetMapping("/usuario/{id}")
	public String verAnuncio(Model model, @PathVariable long id) {
		
		Optional<Usuarios> usu = repository.findById(id);

		if(usu.isPresent()) {
			model.addAttribute("usuario", usu.get());
		}

		return "ver_usuario";
	}
	
	/*
	@GetMapping("/")
	public Collection<Usuarios> getUsuarios(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getPost(@PathVariable long id) {
		Optional<Usuarios> post = repository.findById(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(post.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	/*
	@GetMapping("/")
	public List<Usuarios> EncontrarUsuarios(){
		return repository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Usuarios> addUsu(@RequestBody Usuarios usu) {
		//usu.setId(null);
		Usuarios newUsu = repository.saveAndFlush(usu);
		return new ResponseEntity<>(newUsu,HttpStatus.CREATED);
	}*/
	
	/*

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getItem(@PathVariable long id) {

		Optional<Usuarios> op = repository.findById(id);

		if (op.isPresent()) {
			Usuarios usu = op.get();
			return new ResponseEntity<>(usu, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
/*
	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> updateItem(@RequestBody Usuarios updatedItem,
			@PathVariable long id) {
		updatedItem.setId(id);
		Usuarios usu = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(usu,HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios> deleteItem(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	*/

}
