package br.com.distribuidora.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidora.exception.EntidadeComPendenciaException;
import br.com.distribuidora.mode.Cliente;
import br.com.distribuidora.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.repository.save(cliente);
		
	}

	@Override
	public Cliente buscaPorIdCliente(Long id) {
		Optional<Cliente> cliente = this.repository.findById(id);
		if(cliente.get()== null) {
			throw new EntidadeComPendenciaException("Não foi possível localizar o cliente pesquisado");
		}else {
			return cliente.get();
		}
	}
	public List<Cliente> listarClientes() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public void removerPorCliente(Cliente cliente) {
		this.repository.delete(cliente);
		
	}
    
	@Override
	@Transactional
	public void removerPorId(Long id) {
		this.repository.deleteById(id);

	}


	@Override
	public void remover(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPorId(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

}
