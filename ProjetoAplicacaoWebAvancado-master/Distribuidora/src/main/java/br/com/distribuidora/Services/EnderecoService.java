package br.com.distribuidora.Services;

import java.util.List;

import br.com.distribuidora.mode.Endereco;


public interface EnderecoService {

	Endereco salvar(Endereco endereco);

	List<Endereco> listarEnderecos();

	void removerPorEndereco(Endereco endereco);

	void removerPorId(Long id);

	Endereco buscaPorIdEndereco(Long id);

	void removerPorId(Endereco endereco);

	void save(Endereco enderecoDoBancoDeDados);

	void deleteById(Long id);
	
}