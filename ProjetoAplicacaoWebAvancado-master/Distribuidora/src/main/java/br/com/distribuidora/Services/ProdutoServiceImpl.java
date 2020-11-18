package br.com.distribuidora.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidora.exception.EntidadeNaoEncontradaException;
import br.com.distribuidora.mode.Produto;
import br.com.distribuidora.repository.ProdutoRepository;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		return this.repository.save(produto);
		
	}

	@Override
	public List<Produto> listarProdutos() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public void removerPorProduto(Produto produto) {
		this.repository.delete(produto);
		
	}

	@Override
	@Transactional
	public void removerPorId(Long id) {
		this.repository.deleteById(id);

		
	}
 
	@Override
	public Produto buscaPorIdProduto(Long id) {
		Optional<Produto> produto = this.repository.findById(id);
		if(produto.get()== null) {
			throw new EntidadeNaoEncontradaException("Não foi possível localizar o produto pesquisado");
		}else {
			return produto.get();
		}
	}

	@Override
	public void removerPorId(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Produto produto) {
		// TODO Auto-generated method stub
		
	}

}
