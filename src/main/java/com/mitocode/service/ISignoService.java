package com.mitocode.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Signo;

public interface ISignoService extends ICRUD<Signo>{

	Page<Signo> listarPageable(Pageable pageable);

	Page<Signo> listarPageablePorNombreApellidosAndFecha(String busqueda, LocalDate fecha, Pageable pageable);

	Page<Signo> listarPageablePorNombreApellidos(String busqueda, Pageable pageable);
}
