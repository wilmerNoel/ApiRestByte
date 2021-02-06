package com.wilmer.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wilmer.app.entity.Empresa;


public interface EmpresaService {
public Iterable<Empresa> findAll();
	
	public Page<Empresa> findAll(Pageable pageable);
	
	public Optional<Empresa> findById(Long id);
	
	public Empresa save(Empresa empresa);
	
	public void deleteById(Long id);
}
