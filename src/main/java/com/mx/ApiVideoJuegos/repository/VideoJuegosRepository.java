package com.mx.ApiVideoJuegos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mx.ApiVideoJuegos.entity.VideoJuegos;

public interface VideoJuegosRepository  extends CrudRepository<VideoJuegos, Long>{
	
	public List<VideoJuegos> findByNombre (String nombre);//se crea el metodo findByNombre como resorte
	

}
