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

import com.giramundo.agenciaviagem.entities.Pedido;
import com.giramundo.agenciaviagem.entities.Usuario;
import com.giramundo.agenciaviagem.services.PedidoService;  
@Controller
public class PedidoController {  

    private final PedidoService pedidoService; 

    @Autowired
    public PedidoController(PedidoService pedidoService) {  
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedido.html") 
    public String pedido(Model model) {
        List<Pedido> pedidos = pedidoService.listarTodosPedidos(); 
        model.addAttribute("pedidos", pedidos); 
        return "pedido.html";
    }

    @PostMapping("/cadastrar-pedido") 
    public String cadastrarPedido(Pedido pedido, Model model) { 
        Pedido pedidoCadastrado = pedidoService.cadastrarPedido(pedido); 
        model.addAttribute("pedido", pedidoCadastrado);  
        return "redirect:/pedido.html?sucesso=true"; 
    }

    @DeleteMapping("/excluir-pedido/{id}")  
    public ResponseEntity<Void> excluirPedido(@PathVariable long id) {  
        pedidoService.excluirPedido(id); 
        return ResponseEntity.ok().build();
    }

    @GetMapping("/editar-pedido/{id}")
	@ResponseBody
	public Pedido obterPedidoParaEdicao(@PathVariable long id) {
		return pedidoService.buscarPorId(id).orElseThrow();
	}
}
