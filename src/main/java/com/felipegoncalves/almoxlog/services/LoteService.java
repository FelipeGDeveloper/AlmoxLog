package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.Lote;
import com.felipegoncalves.almoxlog.repositories.LoteRepository;

@Service
public class LoteService {

	@Autowired
	private LoteRepository repository;

	public List<Lote> findAll() {
		return repository.findAll();
	}

	public Lote findById(Long id) {
		Optional<Lote> obj = repository.findById(id);
		return obj.get();
	}

}
