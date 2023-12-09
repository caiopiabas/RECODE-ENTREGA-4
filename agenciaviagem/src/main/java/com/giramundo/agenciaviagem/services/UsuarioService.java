package com.giramundo.agenciaviagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giramundo.agenciaviagem.entities.Usuario;
import com.giramundo.agenciaviagem.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	// Operação de Criação (Create)
	public Usuario cadastrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// Operação de Leitura (Read)
	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> buscarPorId(long id) {
		return usuarioRepository.findById(id);
	}

	// Operação de Atualização (Update)
	public Usuario atualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// Operação de Exclusão (Delete)
	public void excluirUsuario(long id) {
		usuarioRepository.deleteById(id);
	}
}