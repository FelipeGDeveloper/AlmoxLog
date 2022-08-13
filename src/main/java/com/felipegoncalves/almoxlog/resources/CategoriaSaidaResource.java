package com.felipegoncalves.almoxlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegoncalves.almoxlog.entities.CategoriaSaida;
import com.felipegoncalves.almoxlog.services.CategoriaSaidaService;

@RestController
@RequestMapping(value = "/categorias-saidas")
public class CategoriaSaidaResource {

	@Autowired
	private CategoriaSaidaService service;

	@GetMapping
	public ResponseEntity<List<CategoriaSaida>> findAll() {

		List<CategoriaSaida> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaSaida> findById(@PathVariable Long id) {
		CategoriaSaida obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
