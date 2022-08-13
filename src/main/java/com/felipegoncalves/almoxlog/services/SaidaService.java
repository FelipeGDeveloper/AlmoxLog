package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.Saida;
import com.felipegoncalves.almoxlog.repositories.SaidaRepository;

@Service
public class SaidaService {

	@Autowired
	private SaidaRepository repository;

	public List<Saida> findAll() {
		return repository.findAll();
	}

	public Saida findById(Long id) {
		Optional<Saida> obj = repository.findById(id);
		return obj.get();
	}

}
