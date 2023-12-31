package com.giramundo.agenciaviagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.giramundo.agenciaviagem.entities.Usuario;
import com.giramundo.agenciaviagem.services.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;
	
@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/usuario.html")
	public String usuario(Model model) {
		List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuario.html";
	}

	@PostMapping("/cadastrar-usuario")
	public String cadastrarUsuario(Usuario usuario, Model model) {
		Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
		model.addAttribute("usuario", usuarioCadastrado);
		return "redirect:/usuario.html?sucesso=true"; 
	}

	@DeleteMapping("/excluir-usuario/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable long id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/editar-usuario/{id}")
	@ResponseBody
	public Usuario obterUsuarioParaEdicao(@PathVariable long id) {
		return usuarioService.buscarPorId(id).orElseThrow();
	}

}	
