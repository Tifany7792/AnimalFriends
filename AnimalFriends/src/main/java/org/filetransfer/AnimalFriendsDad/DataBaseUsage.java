package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BBDDusuarios")
public class DataBaseUsage {

	
	@Autowired
	private RepositorioUsuarios repository;
	
	@GetMapping("/")
	public List<Usuarios> EncontrarUsuarios(){
		return repository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Usuarios> addUsu(@RequestBody Usuarios usu) {
		usu.setId(null);
		Usuarios newUsu = repository.saveAndFlush(usu);
		return new ResponseEntity<>(newUsu,HttpStatus.CREATED);
	}

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
	
}
