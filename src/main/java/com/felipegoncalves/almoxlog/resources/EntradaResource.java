package com.felipegoncalves.almoxlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegoncalves.almoxlog.entities.Entrada;
import com.felipegoncalves.almoxlog.services.EntradaService;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaResource {

	@Autowired
	private EntradaService service;

	@GetMapping
	public ResponseEntity<List<Entrada>> findAll() {

		List<Entrada> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrada> findById(@PathVariable Long id) {
		Entrada obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
