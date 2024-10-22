package br.com.example.avaliacao.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.avaliacao.security.dto.EnderecoRequestDTO;
import br.com.example.avaliacao.security.dto.EnderecoResponseDTO;
import br.com.example.avaliacao.security.entities.Endereco;
import br.com.example.avaliacao.security.repositories.EnderecoRepository;
import br.com.example.avaliacao.util.Util;

@Service
public class EnderecoService {
    
    @Autowired
    Util util;
    
    @Autowired
    EnderecoRepository enderecoRepository;
    
//    public EnderecoResponseDTO consultarEndereco(String cep, Integer numero, String complemento) {
//        EnderecoResponseDTO viaCep = util.buscarEndereco(cep);
//        
//        EnderecoResponseDTO endereco = new EnderecoResponseDTO();
//        endereco.setCep(viaCep.getCep());
//        endereco.setLogradouro(viaCep.getLogradouro());
//        endereco.setNumero(numero);
//        endereco.setComplemento(complemento);
//        endereco.setBairro(viaCep.getBairro());
//        endereco.setLocalidade(viaCep.getLocalidade());
//        endereco.setUf(viaCep.getUf());
//        endereco.setEstado(viaCep.getEstado());
//        return endereco;
//    }
    
    public EnderecoResponseDTO consultarEndereco(EnderecoRequestDTO enderecoDto) {
        EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoDto.getCep());
        
        EnderecoResponseDTO endereco = new EnderecoResponseDTO();
        endereco.setCep(viaCep.getCep());
        endereco.setLogradouro(viaCep.getLogradouro());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setBairro(viaCep.getBairro());
        endereco.setLocalidade(viaCep.getLocalidade());
        endereco.setUf(viaCep.getUf());
        endereco.setEstado(viaCep.getEstado());
        
        Endereco enderecoConvertido = endereco.toEndereco();
        enderecoRepository.save(enderecoConvertido);
        return endereco;
    }

    public EnderecoResponseDTO buscarEndereco(Integer id) {
//      Endereco endereco = enderecoRepository.findById(id).get();
      Optional <Endereco> endereco = enderecoRepository.findById(id);
      EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
      enderecoResponseDTO.setCep(endereco.get().getCep());
      enderecoResponseDTO.setLogradouro(endereco.get().getLogradouro());
      enderecoResponseDTO.setNumero(endereco.get().getNumero());
      enderecoResponseDTO.setComplemento(endereco.get().getComplemento());
      enderecoResponseDTO.setBairro(endereco.get().getBairro());
      enderecoResponseDTO.setLocalidade(endereco.get().getLocalidade());
      enderecoResponseDTO.setUf(endereco.get().getUf());
      enderecoResponseDTO.setEstado(endereco.get().getEstado());
      
      return enderecoResponseDTO;
  }
    
}