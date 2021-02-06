package com.wilmer.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilmer.app.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
