package br.com.example.veiculo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.veiculo.entities.Veiculo;
import br.com.example.veiculo.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoService.adicionarVeiculo(veiculo);
	}
	
	@GetMapping
	public List<Veiculo> listarVeiculos() {
		return veiculoService.listarVeiculos();
	}
	
	@GetMapping("/{id}")
	public Optional<Veiculo> buscarVeiculo(@PathVariable Long id) {
		return veiculoService.buscarVeiculo(id);
	}

	@PutMapping("/{id}")
	public Optional<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		return veiculoService.atualizarVeiculo(id, veiculo);
	}
	
	@DeleteMapping("/{id}")
	public void removerVeiculo(@PathVariable Long id) {
		veiculoService.removerVeiculo(id);
	}
}
