package com.mitocode.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Integer>{
	//
	@Query("SELECT p FROM Paciente p WHERE UPPER(CONCAT(p.nombres, ' ',p.apellidos)) LIKE %:busqueda%")
	List<Paciente> obtenerPacientePorBusqueda(@Param("busqueda")String busqueda, Pageable pageable);
	
	@Query("SELECT p FROM Paciente p ORDER BY p.idPaciente desc")
	List<Paciente> obtenerUltimoPaciente(Pageable pageable);
}
