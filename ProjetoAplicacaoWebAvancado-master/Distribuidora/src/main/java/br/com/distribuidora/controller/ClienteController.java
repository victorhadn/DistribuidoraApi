package br.com.distribuidora.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidora.mode.Cliente;
import io.swagger.annotations.ApiOperation;
import br.com.distribuidora.Services.ClienteService;


@RestController
@RequestMapping("/clientes/api")
public class ClienteController {

	
	@Autowired
	private ClienteService service;
	
	@ApiOperation(
			value="Listar um cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do cliente.")
	@GetMapping("/v1")
	public List<Cliente> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarClientes();
	}
	@ApiOperation(
			value="Listar um cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do cliente.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Cliente>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarClientes());
	}

	@ApiOperation(
			value="Buscar um cliente", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um cliente por ID.")
	@PutMapping("/{id}")
	public Cliente editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteDoBancoDeDados = this.service.buscaPorIdCliente(id);
		BeanUtils.copyProperties(cliente, clienteDoBancoDeDados, "id");
		this.service.salvar(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um cliente por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdCliente(id));
	}
	
	@ApiOperation(
			value="Salva um cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do cliente.")
	@PostMapping("/v1")
	public Cliente salvarv1(@RequestBody Cliente cliente) {
		return this.service.salvar(cliente);
	}
	
	
	@ApiOperation(
			value="Cadastrar um cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do cliente.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvarv2(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(this.service.salvar(cliente));
	}
}

