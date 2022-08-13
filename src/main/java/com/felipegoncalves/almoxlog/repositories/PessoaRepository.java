package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
