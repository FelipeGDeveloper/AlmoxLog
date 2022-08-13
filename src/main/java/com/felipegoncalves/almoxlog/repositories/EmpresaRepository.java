package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
