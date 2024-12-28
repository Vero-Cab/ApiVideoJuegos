package com.mx.ApiVideoJuegos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.ApiVideoJuegos.entity.VideoJuegos;
import com.mx.ApiVideoJuegos.repository.VideoJuegosRepository;

@Service
public class VideoJuegosImp {

	@Autowired
	VideoJuegosRepository repository;

	@Transactional(readOnly = true)
	public List<VideoJuegos> listar() {
		return (List<VideoJuegos>) repository.findAll();
	}

	// VALIDACIONES al guardar ---- Que el nombre no se repita
	@Transactional
	public boolean guardar(VideoJuegos videojuego) {
		boolean bandera = false;
		for (VideoJuegos v : repository.findAll()) {
			if (v.getNombre().equals(videojuego.getNombre())) {
				bandera = true;
				break;
			}

		}
		if (bandera == false)
			repository.save(videojuego);
		return bandera;
	}

	@Transactional(readOnly = true)
	public VideoJuegos buscar(long idVideo) {
		return repository.findById(idVideo).orElse(null);
	}

	// validar que el id exista para podder editar
	@Transactional
	public boolean editar(@RequestBody VideoJuegos videojuego) {
		boolean bandera = false;
		for (VideoJuegos v : repository.findAll()) {
			if (v.getId().equals(videojuego.getId())) {
				repository.save(videojuego);// actualiza el registro
				bandera = true;
				break;
			}
		}
		return bandera;
	}

	// Validar que el id exista para poder eliminar
	@Transactional

	public boolean eliminar(@RequestBody VideoJuegos videojuego) {
		boolean bandera = false;
		for (VideoJuegos v : repository.findAll()) {
			if (v.getId().equals(videojuego.getId())) {
				repository.delete(videojuego);// actualiza el registro Y Elimina
				bandera = true;
				break;
			}
		}
		return bandera;
	}

	// Buscar por nombre del VideoJuego-----objeto
	@Transactional(readOnly = true)
	public List<VideoJuegos> buscarXnombre(String nombre) {
		return repository.findByNombre(nombre);// Lo realice por metodo de resorte
	}

	// Buscar por genero---listaObjetos con el ciclo for para recorrer la lista
	@Transactional(readOnly = true)
	public List<VideoJuegos> buscarXgenero(String genero) {
		List<VideoJuegos> nuevaList = new ArrayList<>();
		for (VideoJuegos c : repository.findAll()) {
			if (c.getGenero().equals(genero)) {
				nuevaList.add(c);
			}
		}
		return nuevaList;
	}
//Eliminar por nombre--- si existe el nombre eliminamos
	//CON VALIDACIONES
	
	public boolean eliminarXnombre(@RequestBody VideoJuegos videojuego) {
	boolean bandera = false;
	for(VideoJuegos v: repository.findAll()) {
		if(v.getNombre().equals(videojuego.getNombre())) {
			repository.delete(videojuego); //actualiza el registro lo encuentra y elimina
		bandera = true;
		break;
		}
		
	}
	
	return bandera;
	
}
}

