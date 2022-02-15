package org.filetransfer.AnimalFriendsDad;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private ConcurrentMap<Long, Usuarios> usuarios = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	public UserService() {
		save(new Usuarios("Tifany", "771992"));
		save(new Usuarios("Pedro", "Gato2"));
	}

	public Collection<Usuarios> findAll() {
		return usuarios.values();
	}

	public Usuarios findById(long id) {
		return usuarios.get(id);
	}

	public void save(Usuarios usu) {

		long id = nextId.getAndIncrement();

		usu.setId(id);

		this.usuarios.put(id, usu);
	}

	public void deleteById(long id) {
		this.usuarios.remove(id);
	}

}
