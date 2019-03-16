package com.mitocode.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Paciente;
import com.mitocode.model.Signo;

public interface ISignoService extends ICRUD<Signo>{

	Page<Signo> listarPageable(Pageable pageable);
	
	List<Paciente> buscarPacientePorNombreApellidos(String busqueda);

	Page<Signo> listarPageablePorNombreApellidosAndFecha(String busqueda, LocalDate fecha, Pageable pageable);

	Page<Signo> listarPageablePorNombreApellidos(String busqueda, Pageable pageable);
}
