package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.CategoriaSaida;
import com.felipegoncalves.almoxlog.repositories.CategoriaSaidaRepository;

@Service
public class CategoriaSaidaService {

	@Autowired
	private CategoriaSaidaRepository repository;

	public List<CategoriaSaida> findAll() {
		return repository.findAll();
	}

	public CategoriaSaida findById(Long id) {
		Optional<CategoriaSaida> obj = repository.findById(id);
		return obj.get();
	}

}
