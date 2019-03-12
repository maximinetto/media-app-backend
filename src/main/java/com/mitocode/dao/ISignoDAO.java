 package com.mitocode.dao;
 

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mitocode.model.Signo;

public interface ISignoDAO extends JpaRepository<Signo, Integer>,PagingAndSortingRepository<Signo, Integer>{
	
}
