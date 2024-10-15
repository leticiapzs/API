package br.com.example.veiculo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.veiculo.entities.Veiculo;
import br.com.example.veiculo.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo adicionarVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}
	
	public Optional<Veiculo> buscarVeiculo(Long id) {
		return veiculoRepository.findById(id);
	}
	
	
	public void removerVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}

	public Optional<Veiculo> atualizarVeiculo(Long id, Veiculo veiculo) {
		return veiculoRepository.findById(id);
	}
}
