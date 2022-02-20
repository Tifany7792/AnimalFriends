package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalizacionService {
	@Autowired
	private RepositorioLocalizaciones localizaciones;

	private Localizaciones miLocalizacion;


	public boolean existe(String tipo, String nombre) {
		Optional<Localizaciones> l = localizaciones.findByTipo(tipo);

		if (l.isPresent()) {
			if (l.get().getNombreSitio().equals(nombre)) {
				miLocalizacion = l.get();
				return true;
			} else {
				miLocalizacion = null;
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registrarLocalizacion(String tipo, String nombre) {
		Optional<Localizaciones> l = localizaciones.findByNombreSitio(nombre);

		if (!l.isPresent()) {
			miLocalizacion = new Localizaciones(nombre, tipo);
			localizaciones.save(miLocalizacion);
			return true;
		} else {
			miLocalizacion = null;
			return false;
		}
	}

	public void logout() {
		miLocalizacion = null;
	}

	public List<Localizaciones> getAllLocalizaciones() {
		return localizaciones.findAll();
	}

	public Localizaciones getMiLocalizacion() {
		return miLocalizacion;
	}

	public Localizaciones getLocalizacion(long id) {
		Optional<Localizaciones> aux = localizaciones.findById(id);
		if (aux.isPresent())
			return aux.get();
		else
			return null;
	}

}
