package com.felipegoncalves.almoxlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegoncalves.almoxlog.entities.Fornecedor;
import com.felipegoncalves.almoxlog.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	public List<Fornecedor> findAll() {
		return repository.findAll();
	}

	public Fornecedor findById(Long id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.get();
	}

}
