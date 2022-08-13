package com.felipegoncalves.almoxlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegoncalves.almoxlog.entities.Lote;
import com.felipegoncalves.almoxlog.services.LoteService;

@RestController
@RequestMapping(value = "/lotes")
public class LoteResource {

	@Autowired
	private LoteService service;

	@GetMapping
	public ResponseEntity<List<Lote>> findAll() {

		List<Lote> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lote> findById(@PathVariable Long id) {
		Lote obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
