package br.com.distribuidora.Services;

import java.util.List;

import br.com.distribuidora.mode.Fornecedor;


public interface FornecedorService {

	List<Fornecedor> listarFornecedores();;

	void removerPorId(Fornecedor fornecedor);

	Fornecedor buscaPorIdFornecedor(Long id);
	
	Fornecedor salvar(Fornecedor fornecedor);
	
	void removerPorFornecedor(Fornecedor fornecedor);

	Fornecedor findById(Long id);

	void save(Fornecedor fornecedorDoBancoDeDados);

	void deleteById(Long id);

	void removerPorId(Long id);

	
}