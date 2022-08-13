package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

}
