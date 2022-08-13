package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.EntradaItem;

public interface EntradaItemRepository extends JpaRepository<EntradaItem, Long> {

}
