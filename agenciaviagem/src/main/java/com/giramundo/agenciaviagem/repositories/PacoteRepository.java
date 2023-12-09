package com.giramundo.agenciaviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giramundo.agenciaviagem.entities.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
