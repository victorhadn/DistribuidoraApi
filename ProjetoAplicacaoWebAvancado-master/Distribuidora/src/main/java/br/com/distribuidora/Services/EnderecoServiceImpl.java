package br.com.distribuidora.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidora.mode.Endereco;
import br.com.distribuidora.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	@Override
	@Transactional
	public Endereco salvar(Endereco endereco) {
		return this.repository.save(endereco);
		
	}
	

	@Override
	public List<Endereco> listarEnderecos() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public void removerPorEndereco(Endereco endereco) {
		this.repository.delete(endereco);
		
	}
    
	@Override
	@Transactional
	public void removerPorId(Long id) {
		this.repository.deleteById(id);

	}

	@Override
	public Endereco buscaPorIdEndereco(Long id) {
		this.repository.findById(id);
		return null;
		
	}

	@Override
	public void removerPorId(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save(Endereco enderecoDoBancoDeDados) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}