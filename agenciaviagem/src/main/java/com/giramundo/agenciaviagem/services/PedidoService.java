package com.giramundo.agenciaviagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giramundo.agenciaviagem.entities.Pedido;
import com.giramundo.agenciaviagem.repositories.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	// Operação de Criação (Create)
	public Pedido cadastrarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	// Operação de Leitura (Read)
	public List<Pedido> listarTodosPedidos() {
		return pedidoRepository.findAll();
	}

	public Optional<Pedido> buscarPorId(long id) {
		return pedidoRepository.findById(id);
	}

	// Operação de Atualização (Update)
	public Pedido atualizarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	// Operação de Exclusão (Delete)
	public void excluirPedido(long id) {
		pedidoRepository.deleteById(id);
	}
}
