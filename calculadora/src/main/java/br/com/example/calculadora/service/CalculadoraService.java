package br.com.example.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	
	public double soma(double a, double b) {
		return a + b;
	}
	
	public double subtracao(double a, double b) {
		return a - b;
	}
	
	public double multiplicacao(double a, double b) {
		return a * b;
	}
	
	public double divisao(double a, double b) {
		return a/b;
	}
		
}