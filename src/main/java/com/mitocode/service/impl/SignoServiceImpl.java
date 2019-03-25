package com.mitocode.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.dao.ISignoDAO;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoService;

@Service
public class SignoServiceImpl implements ISignoService{

	@Autowired
	private ISignoDAO signoDao;
	
	@Override
	public Signo registrar(Signo t) {
		return signoDao.save(t);
	}

	@Override
	public Signo modificar(Signo t) {
		return signoDao.save(t);
	}

	@Override
	public void eliminar(int id) {
		signoDao.delete(id);
	}

	@Override
	public Signo listarId(int id) {
		return signoDao.findOne(id);
	}

	@Override
	public List<Signo> listar() {
		return signoDao.findAll();
	}

	@Override
	public Page<Signo> listarPageable(Pageable pageable) {
		return signoDao.findAll(pageable);
	}
	
	@Override
	public Page<Signo> listarPageablePorNombreApellidosAndFecha(String busqueda, 
			LocalDate fecha, Pageable pageable) {
		busqueda = busqueda.toUpperCase();
		return signoDao.findByPacienteAndFecha(busqueda, fecha, pageable);
	}
	
	@Override
	public Page<Signo> listarPageablePorNombreApellidos(String busqueda, Pageable pageable) {
		busqueda = busqueda.toUpperCase();
		return signoDao.findByPaciente(busqueda, pageable);
	}
	
	

	

}
