package es.codeurjc.AnimalFriendsDad;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import es.codeurjc.AnimalFriendsDad.entidades.Animal;
import es.codeurjc.AnimalFriendsDad.entidades.Usuarios;
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
	
	public boolean existeUsuario(String name) {
		if (usuarios.size() > 0) {
			Collection<Usuarios> u = findAll();
			Object[] a = u.toArray();
			
			for (int i = 0; i < usuarios.size(); i++) {
				System.out.print(a[i].getClass().getName());
				if (a[i].getClass().getName() == name)
					
					return true;
			}
		}
		
		return false;
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
