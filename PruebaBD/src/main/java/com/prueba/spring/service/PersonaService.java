package com.prueba.spring.service;

import java.util.Optional;

import org.springframework.data.domain.*;

import com.prueba.spring.entity.Persona;

public interface PersonaService {
	public Iterable<Persona> findAll();
	/*La diferencia es que las listas proporcionan métodos para manipular elementos individuales
	 y los iterables solo proporcionan la capacidad de recorrer la secuencia de elementos.
	 */
	public Page<Persona> findAll(Pageable pageable);
	/*  la clase "Page" es una forma conveniente de devolver un número limitado de resultados por página, mejora
	 la experiencia del usuario al interactuar con aplicaciones que manejan grandes cantidades de datos.
	 */
	public Optional<Persona> findById(Long id);
	/* Sin "Optional", podrías devolver "null" en este caso, lo que podría dar lugar a errores en tiempo de ejecución 
	 si el código que llama al método no verifica explícitamente si el resultado es "null".
	 Con "Optional"puedes devolver un objeto "Optional" que representa el resultado opcional. Si 
	 la persona se encuentra en la base de datos puedes devolver un "Optional" que contiene un objeto "Persona".Si la persona
	  no se encuentra puedes devolver un "Optional" vacío.*/
	public Persona save(Persona persona); 
	/*Este método guarda una nueva entidad "Persona" o actualiza una entidad existente en la base de datos.*/
	public void deleteById(Long id);
}
