package com.prueba.spring.controller;

import java.util.*;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.prueba.spring.entity.Persona;
import com.prueba.spring.service.PersonaService;

@RestController //Los métodos en un controlador de REST manejan solicitudes HTTP y producen respuestas formato JSON o XML
@RequestMapping("/api/persona")
public class PersonaController{	
	@Autowired
	private PersonaService personaService;
	/*En este caso, solo existe una clase que implementa la interfaz, por lo que Spring sabe automáticamente qué clase
	 usar para inyectar en el atributo, se puede usar la interfaz en lugar de tener que conocer la clase que implementa
	 */
	//Create a new person
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Persona persona){ 
		// La clase ResponseEntity permite especificar el estado HTTP
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
		//crea una respuesta HTTP con un estado HttpStatus.CREATED y el cuerpo va a regresar un codigo de estado y la persona
	}
	//Read an person
	@GetMapping("/{id}") //el valor pertenece a la variable id del metodo read o en todo caso usar el (value="id")
	public ResponseEntity<?> read(@PathVariable Long id){
		/*@PathVariable vincula una variable de la URL a un parámetro en un método controlador */
		Optional<Persona> opersona=personaService.findById(id);
		if(!opersona.isPresent()) {
			return ResponseEntity.notFound().build();//devolvera respuesta con el codigo 404
		}
		return ResponseEntity.ok(opersona);//devuelve codigo de estado 200 y devuelve la persona
	}
	//Update an person
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Persona personaDetails,@PathVariable Long id){
		/*@RequestBody en un método del controlador se usa para deserializar el JSON en un objeto Java y utilizar 
		 ese objeto,@RequestBody permite recibir y procesar los datos enviados en el cuerpo de una solicitud HTTP.*/
		Optional<Persona> opersona= personaService.findById(id);
		if(!opersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		opersona.get().setNombre(personaDetails.getNombre()); //get es para obtener el objeto usuario del optional
		opersona.get().setEdad(personaDetails.getEdad());
		opersona.get().setTelefono(personaDetails.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(opersona.get()));
		
	}
	//Delete an person
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!personaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		personaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//Read all persons
	@GetMapping
	public List<Persona> readAll(){
		List<Persona> personas=StreamSupport
				.stream(personaService.findAll().spliterator(),false)//recorre la iterable
				.collect(Collectors.toList()); //lo transforma en una lista
		return personas;
	}
}
