package br.com.example.calculadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.calculadora.service.CalculadoraService;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@Autowired
	CalculadoraService calculadoraService;
	
	@GetMapping("/soma")
	public double soma(@RequestParam double a, @RequestParam double b) {
		return calculadoraService.soma(a, b);		
	}
	
	@GetMapping("/subtracao")
	public double subtracao(@RequestParam double a, @RequestParam double b) {
		return calculadoraService.subtracao(a, b);		
	}
	
	@GetMapping("/multiplicacao")
	public double multiplicacao(@RequestParam double a, @RequestParam double b) {
		return calculadoraService.multiplicacao(a, b);		
	}
	
	@GetMapping("/divisao")
	public double divisao(@RequestParam double a, @RequestParam double b) {
		return calculadoraService.divisao(a, b);		
	}
	
}
