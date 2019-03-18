package com.mitocode.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoService;

@RestController
@RequestMapping("/signos")
public class SignoController {
	
	@Autowired
	private ISignoService service;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Signo>> listar() {	
		return new ResponseEntity<List<Signo>>(service.listar(), HttpStatus.OK);		
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Signo>> listarPageable(Pageable pageable){
		Page<Signo> signo;
		signo = service.listarPageable(pageable);
		return new ResponseEntity<Page<Signo>>(signo, HttpStatus.OK);
	}
	
	@GetMapping(value="/busqueda/pageable", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Signo>> listarPageablePorNombreApellidosOrFecha
			(@RequestParam(value = "busqueda", required = true)String busqueda,
					@RequestParam(value = "fecha", required = false) @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate fecha,
					Pageable pageable){
		Page<Signo> signo;
		if(fecha != null)
			signo = service.listarPageablePorNombreApellidosAndFecha(busqueda, fecha, pageable);
		else
			signo = service.listarPageablePorNombreApellidos(busqueda, pageable);
		
		return new ResponseEntity<Page<Signo>>(signo, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Signo> listarPorId(@PathVariable("id") Integer id) {
		Signo signo = service.listarId(id);
		if(signo == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		Resource<Signo> resource = new Resource<Signo>(signo);
		//  /Signos/1
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Signo-resource"));
		
		return resource;
	}
	
	@GetMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paciente>> listarPacienteSigno(@RequestParam(value = "busqueda", required = false) String busqueda){
		List<Paciente> pacientes = service.buscarPacientePorNombreApellidos(busqueda);
		return new ResponseEntity<>(pacientes, HttpStatus.OK);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Signo sig) {
		Signo signo = new Signo();
		signo = service.registrar(sig);
		// /Signos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(signo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Signo signo) {
		service.modificar(signo);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Signo signo = service.listarId(id);
		if (signo == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
