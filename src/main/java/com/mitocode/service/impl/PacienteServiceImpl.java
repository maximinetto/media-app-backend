package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPacienteDAO;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{
		
	@Autowired
	private IPacienteDAO dao;

	@Override
	public Paciente registrar(Paciente t) {
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		return dao.save(t);		
	}

	@Override
	public void eliminar(int id) {
		dao.delete(id);
	}

	@Override
	public Paciente listarId(int id) {
		return dao.findOne(id);
	}

	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {
		return dao.findAll(pageable);
	}
	
	@Override
	public List<Paciente> buscarPacientePorNombreApellidos(String busqueda)
	{
		busqueda = busqueda.toUpperCase();
		Sort sort = new Sort("nombres", "apellidos");
		Pageable pageable = new PageRequest(0, 10, sort);
		return dao.obtenerPacientePorBusqueda(busqueda, pageable);
		
	}
	
	@Override
	public Paciente obtenerUltimoPaciente() {
		Pageable pageable = new PageRequest(0, 1);
		return dao.obtenerUltimoPaciente(pageable).stream().findFirst().orElse(null);
	}

}
