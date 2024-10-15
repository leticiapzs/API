package br.com.example.veiculo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.example.veiculo.entities.Veiculo;

@Repository("veiculo")
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	List<Veiculo> findByMarca(String marca);
	List<Veiculo> findByModelo(String modelo);
	Optional<Veiculo> findById(Integer id);
	

}
