package com.felipegoncalves.almoxlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegoncalves.almoxlog.entities.Saida;
import com.felipegoncalves.almoxlog.services.SaidaService;

@RestController
@RequestMapping(value = "/saidas")
public class SaidaResource {

	@Autowired
	private SaidaService service;

	@GetMapping
	public ResponseEntity<List<Saida>> findAll() {

		List<Saida> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Saida> findById(@PathVariable Long id) {
		Saida obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
