package com.felipegoncalves.almoxlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipegoncalves.almoxlog.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
