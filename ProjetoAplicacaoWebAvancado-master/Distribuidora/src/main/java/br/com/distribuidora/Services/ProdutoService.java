package br.com.distribuidora.Services;

import java.util.List;

import br.com.distribuidora.mode.Produto;


public interface ProdutoService {

	List<Produto> listarProdutos();
	
	void removerPorId(Produto produto);
	
	Produto buscaPorIdProduto(Long id);

	void removerPorProduto(Produto produto);

	void removerPorId(Long id);

	void remover(Produto produto);

	Produto salvar(Produto produto);
	



}