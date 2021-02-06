package com.wilmer.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilmer.app.entity.Empresa;
import com.wilmer.app.service.EmpresaService;


@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	@Autowired
	private EmpresaService userService;
	//create new empresa
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Empresa empresa){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(empresa));
	}
	//read an empresa
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Empresa> oEmpresa = userService.findById(id);
		if(!oEmpresa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oEmpresa);
	}
	//read all Empresa
	@GetMapping
	public List<Empresa> readAll(){
		List<Empresa> lista = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lista;
	}
	//Update Empresa
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Empresa empresaDetails,@PathVariable Long id){
		Optional<Empresa> empresa=userService.findById(id);
		if(!empresa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//util las propiedades get y set
		empresa.get().setNombre(empresaDetails.getNombre());
		empresa.get().setNumeroNit(empresaDetails.getNumeroNit());
		empresa.get().setFechaFundacion(empresaDetails.getFechaFundacion());
		empresa.get().setDireccion(empresaDetails.getDireccion());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(empresa.get()));
	}
	//delete an empresa
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!userService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
