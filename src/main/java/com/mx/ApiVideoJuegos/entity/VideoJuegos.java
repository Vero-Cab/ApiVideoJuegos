package com.mx.ApiVideoJuegos.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE VIDEO_JUEGO(
ID NUMBER PRIMARY KEY, ------AUTOINCREMENTABLE
NOMBRE VARCHAR2(100) NOT NULL,
PRECIO NUMBER,
GENERO VARCHAR2(80) NOT NULL,
FECHA_LANZ DATE
);*/

//Serializacion: desintegracion  en bytes del estado de un objeto
//Deserealizacion: reconstruccion del estado del objeto apartir de los bytes

@Entity
@Table(name="VIDEO_JUEGO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideoJuegos implements Serializable {
	
	//Es una variable que tiene un datos estatico que puede cambiar solo si hay de 
	//por medio una EXEPCION
	
	private static final long serialVersionUID = 1L;
	
	
	//utilizando la llave primary autoincrementable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Esyo es cuando la llave primaria es autoincrementable
	
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO")
	private Float precio;
	
	@Column(name = "GENERO")
	private String genero;
	
	@Column(name = "FECHA_LANZ")//AÑO-MES-DIA
	private Date fechaLanz;
	
	
	

}
