 package com.mitocode.dao;
 

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Signo;

public interface ISignoDAO extends JpaRepository<Signo, Integer>{

	@Query(value = "SELECT s FROM Signo s WHERE "
			+ "s.fecha = :fecha AND "
			+ "UPPER(CONCAT(s.paciente.nombres, ' ',s.paciente.apellidos)) LIKE %:busqueda%")
	Page<Signo>	findByPacienteAndFecha(@Param("busqueda")String busqueda, 
			@Param("fecha")LocalDate fecha, Pageable pageable);
	
	@Query(value = "SELECT s FROM Signo s WHERE "
				+ "UPPER(CONCAT(s.paciente.nombres, ' ',s.paciente.apellidos)) LIKE %:busqueda%")
	Page<Signo>	findByPaciente(@Param("busqueda")String busqueda,  Pageable pageable);
}
