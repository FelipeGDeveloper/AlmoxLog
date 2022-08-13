package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.Transportadora;
import com.felipegoncalves.almoxlog.repositories.TransportadoraRepository;

@Service
public class TransportadoraService {

	@Autowired
	private TransportadoraRepository repository;

	public List<Transportadora> findAll() {
		return repository.findAll();
	}

	public Transportadora findById(Long id) {
		Optional<Transportadora> obj = repository.findById(id);
		return obj.get();
	}

}
