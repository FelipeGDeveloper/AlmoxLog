package com.felipegoncalves.almoxlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegoncalves.almoxlog.entities.Transportadora;
import com.felipegoncalves.almoxlog.services.TransportadoraService;

@RestController
@RequestMapping(value = "/transportadoras")
public class TransportadoraResource {

	@Autowired
	private TransportadoraService service;

	@GetMapping
	public ResponseEntity<List<Transportadora>> findAll() {

		List<Transportadora> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Transportadora> findById(@PathVariable Long id) {
		Transportadora obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
