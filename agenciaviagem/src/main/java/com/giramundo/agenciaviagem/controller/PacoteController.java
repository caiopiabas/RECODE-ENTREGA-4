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

import com.giramundo.agenciaviagem.entities.Pacote;
import com.giramundo.agenciaviagem.entities.Usuario;
import com.giramundo.agenciaviagem.services.PacoteService;  

@Controller
public class PacoteController {  

    private final PacoteService pacoteService;  

    @Autowired
    public PacoteController(PacoteService pacoteService) {  
        this.pacoteService = pacoteService;
    }

    @GetMapping("/pacote.html")  
    public String pacote(Model model) {  
        List<Pacote> pacotes = pacoteService.listarTodosPacotes(); 
        model.addAttribute("pacotes", pacotes);  
        return "pacote.html";  
    }

    @PostMapping("/cadastrar-pacote")  
    public String cadastrarPacote(Pacote pacote, Model model) {  
        Pacote pacoteCadastrado = pacoteService.cadastrarPacote(pacote); 
        model.addAttribute("pacote", pacoteCadastrado); 
        return "redirect:/pacote.html?sucesso=true"; 
    }

    @DeleteMapping("/excluir-pacote/{id}") 
    public ResponseEntity<Void> excluirPacote(@PathVariable long id) {  
        pacoteService.excluirPacote(id); 
        return ResponseEntity.ok().build();
    }

    @GetMapping("/editar-pacote/{id}")
	@ResponseBody
	public Pacote obterPacoteParaEdicao(@PathVariable long id) {
		return pacoteService.buscarPorId(id).orElseThrow();
	}
}
