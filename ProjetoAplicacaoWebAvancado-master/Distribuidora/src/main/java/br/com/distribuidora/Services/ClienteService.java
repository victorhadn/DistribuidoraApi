package br.com.distribuidora.Services;

import java.util.List;

import br.com.distribuidora.mode.Cliente;


public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	
	List<Cliente> listarClientes();
	
	void removerPorId(Cliente cliente);
	
	Cliente buscaPorIdCliente(Long id);

	void removerPorCliente(Cliente cliente);

	void removerPorId(Long id);

	void remover(Cliente cliente);
}