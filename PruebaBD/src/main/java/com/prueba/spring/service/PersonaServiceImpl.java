package com.prueba.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.spring.DAO.PersonaDAO;
import com.prueba.spring.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService  {
	@Autowired
	private PersonaDAO personaDAO; 
	/* La inyección de dependencias te evita tener que crear una instacia */
	@Override
	@Transactional(readOnly=true) //solo es lectura ,no va a guardar nada en la bd 
	public Iterable<Persona> findAll() {
		return personaDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Persona> findAll(Pageable pageable) {
		return personaDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Persona> findById(Long id) {
		return personaDAO.findById(id);
	}

	@Override
	@Transactional //va a hacer cambios en la bd
	public Persona save(Persona persona) {
		return personaDAO.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personaDAO.deleteById(id);
	}

}
