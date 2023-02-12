package com.prueba.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.spring.entity.Persona;

@Repository
public interface PersonaDAO extends JpaRepository<Persona,Long> { 
	/*La interfaz "JpaRepository" es una interfaz genérica que proporciona una implementación básica de las operaciones CRUD
	  para un tipo de entidad específico, en este caso, la entidad "Persona",la clave primaria se define como "Long".
	  Al extender de "JpaRepository", "PersonaDAO" se convierte en un repositorio Spring Data JPA que puede ser utilizado
	  para realizar operaciones CRUD en la tabla de persona
	 */
	
}
