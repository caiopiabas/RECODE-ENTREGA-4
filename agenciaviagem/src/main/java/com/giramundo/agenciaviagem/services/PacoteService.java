package com.giramundo.agenciaviagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giramundo.agenciaviagem.entities.Pacote;
import com.giramundo.agenciaviagem.repositories.PacoteRepository;

@Service
public class PacoteService {

	private final PacoteRepository pacoteRepository;

	public PacoteService(PacoteRepository pacoteRepository) {
		this.pacoteRepository = pacoteRepository;
	}

	// Operação de Criação (Create)
	public Pacote cadastrarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	// Operação de Leitura (Read)
	public List<Pacote> listarTodosPacotes() {
		return pacoteRepository.findAll();
	}

	public Optional<Pacote> buscarPorId(long id) {
		return pacoteRepository.findById(id);
	}

	// Operação de Atualização (Update)
	public Pacote atualizarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	// Operação de Exclusão (Delete)
	public void excluirPacote(long id) {
		pacoteRepository.deleteById(id);
	}
}
