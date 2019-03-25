package com.mitocode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente>{
	
	Page<Paciente> listarPageable(Pageable pageable);

	List<Paciente> buscarPacientePorNombreApellidos(String busqueda);

	Paciente obtenerUltimoPaciente();
	
}
