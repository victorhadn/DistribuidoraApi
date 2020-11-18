package br.com.distribuidora.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidora.mode.Fornecedor;
import br.com.distribuidora.repository.FornecedorRepository;


@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		return this.repository.save(fornecedor);
		
	}

	@Override
	public List<Fornecedor> listarFornecedores() {
		return this.repository.findAll();
	}
	
	@Transactional
	public void removerPorFornecedor(Fornecedor fornecedor) {
		this.repository.delete(fornecedor);
		
	}
    
	@Override
	@Transactional
	public void removerPorId(Long id) {
		this.repository.deleteById(id);

	}

	@Override
	public Fornecedor buscaPorIdFornecedor(Long id) {
		this.repository.findById(id);
		return null;
		
	}

	@Override
	public void removerPorId(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Fornecedor fornecedorDoBancoDeDados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
