package com.mx.ApiVideoJuegos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiVideoJuegos.entity.VideoJuegos;
import com.mx.ApiVideoJuegos.service.VideoJuegosImp;

@RestController
@RequestMapping(path = "VideoJuegos")
@CrossOrigin

public class VideoJuegosWebService {
	@Autowired
	VideoJuegosImp imp;

	// http://localhost:9000/VideoJuegos/listar
	@GetMapping(path = "listar")
	public List<VideoJuegos> listar() {
		return imp.listar();
	}

	// ResponseEntity es para enviar una respuesta del lado del servidor al cliente

	// http://localhost:9000/VideoJuegos/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody VideoJuegos videojuego) {
		boolean response = imp.guardar(videojuego);
		if (response == true)
			return new ResponseEntity<>("Ese nombre ya existe, ingrese otro", HttpStatus.OK);
		else
			return new ResponseEntity<>(videojuego, HttpStatus.CREATED);
	}

	// http://localhost:9000/VideoJuegos/buscar
	@PostMapping(path = "buscar")
	public VideoJuegos buscar(@RequestBody VideoJuegos videojuego) {
		return imp.buscar(videojuego.getId());
	}

	// http://localhost:9000/VideoJuegos/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody VideoJuegos videojuego) {
		boolean response = imp.editar(videojuego);
		if (response == true)
			return new ResponseEntity<>(videojuego, HttpStatus.CREATED);
		else

			return new ResponseEntity<>("ese id no existe, ingresa otro", HttpStatus.OK);
	}

	// http://localhost:9000/VideoJuegos/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody VideoJuegos videojuego) {
		boolean response = imp.eliminar(videojuego);
		if (response == true)
			return new ResponseEntity<>(videojuego, HttpStatus.CREATED);
		else

			return new ResponseEntity<>("Id no existe, ingresa otro", HttpStatus.OK);
	}

	// http://localhost:9000/VideoJuegos/buscarXnombre
	@PostMapping(path = "buscarXnombre")
	public List<VideoJuegos> buscarXnombre(@RequestBody VideoJuegos videojuego) {
		return imp.buscarXnombre(videojuego.getNombre()); // me envia el nombre del encapsulamiento de busqueda

	}
	// http://localhost:9000/VideoJuegos/buscarXgenero
	@PostMapping(path = "buscarXgenero")
	public List<VideoJuegos> buscarXgenero(@RequestBody VideoJuegos videojuego){
		return imp.buscarXgenero(videojuego.getGenero());
	}
	
	// http://localhost:9000/VideoJuegos/buscarXgenero
	@PostMapping(path = "eliminarXnombre")
	public ResponseEntity<?> eliminarXnombre(@RequestBody VideoJuegos videojuego){
		boolean response = imp.eliminarXnombre(videojuego);
		if(response == true)
			return new ResponseEntity<>(videojuego,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("No existe el nombre para eliminar", HttpStatus.OK);
	}

}
