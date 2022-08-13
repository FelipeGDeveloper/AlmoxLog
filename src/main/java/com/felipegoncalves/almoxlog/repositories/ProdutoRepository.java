package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
