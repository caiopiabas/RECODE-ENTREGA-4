package com.giramundo.agenciaviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giramundo.agenciaviagem.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
