package org.filetransfer.AnimalFriendsDad;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {

	private ConcurrentMap<Long, Animal> animales = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	public AnimalService() {
		save(new Animal("", "Perro"));
		save(new Animal("", "Gato"));
	}

	public Collection<Animal> findAll() {
		return animales.values();
	}

	public Animal findById(long id) {
		return animales.get(id);
	}

	public void save(Animal animal) {

		long id = nextId.getAndIncrement();

		animal.setId(id);

		this.animales.put(id, animal);
	}

	public void deleteById(long id) {
		this.animales.remove(id);
	}
	
}
