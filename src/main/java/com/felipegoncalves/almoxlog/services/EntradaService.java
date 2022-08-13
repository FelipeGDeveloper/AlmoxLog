package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.Entrada;
import com.felipegoncalves.almoxlog.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repository;

	public List<Entrada> findAll() {
		return repository.findAll();
	}

	public Entrada findById(Long id) {
		Optional<Entrada> obj = repository.findById(id);
		return obj.get();
	}

}
