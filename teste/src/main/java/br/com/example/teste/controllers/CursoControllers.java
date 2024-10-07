package br.com.example.teste.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoControllers {
	
	@GetMapping
	public String  teste() {
		return "Olá Mundo!";
	}

}
