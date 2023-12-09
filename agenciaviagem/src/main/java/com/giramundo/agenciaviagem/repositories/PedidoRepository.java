package com.giramundo.agenciaviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giramundo.agenciaviagem.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
