package com.giramundo.agenciaviagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/index.html" })
	public String index() {
		return "index.html";
	}

	@GetMapping("/contato.html")
	public String contato() {
		return "contato.html";
	}

	@GetMapping("/destino.html")
	public String destino() {
		return "destino.html";
	}

	@GetMapping("/promocoes.html")
	public String promocoes() {
		return "promocoes.html";
	}

}
