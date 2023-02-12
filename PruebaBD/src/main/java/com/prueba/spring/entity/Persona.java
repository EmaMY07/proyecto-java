package com.prueba.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name="persona")
public class Persona { //con todo este proceso se crea una tabla llamada persona 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre",nullable=false,length=20) 
	private String nombre;
	@Column(name="edad",nullable=false,length=2)
	private int edad;
	@Column(name="telefono",nullable=false,length=9,unique=true)//nombre de tabla ,not null ,longitud,unico
	private int telefono;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
   
}
