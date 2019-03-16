package com.mitocode;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitocode.dao.ISignoDAO;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuscarSignos {
	@Autowired
	private ISignoService service;
	
	@Test
	public void buscarPorPacienteOrFecha() {
		String busqueda = "ruiz";
		LocalDate fecha = LocalDate.of(2019, 3, 15);
		Sort sort = new Sort("paciente.nombres", "paciente.apellidos", "fecha");
		Pageable pageable = new PageRequest(0, 2, sort);
		
		Page<Signo> page = service.listarPageablePorNombreApellidosAndFecha
				(busqueda, fecha, pageable);
		assertEquals(1, page.getTotalElements());
	    page.forEach(signo -> System.out.println(signo));
	}
}
