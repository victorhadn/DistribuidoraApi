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

import br.com.distribuidora.Services.EnderecoService;
import br.com.distribuidora.mode.Endereco;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/endereco/api")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@ApiOperation(
			value="Lista um novo endereço", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo endereço.")
	@GetMapping("/v1")
	public List<Endereco> listarv1() {
		System.out.println("Chamando a versão 1");
		return null;
	}
	
	@ApiOperation(
			value="Lista um novo endereço", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo endereço.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> Listarv2() {
		return null;
	}

	@ApiOperation(
			value="Busca um novo endereço por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um novo endereço por ID.")
	@PutMapping("/{id}")
	public Endereco editar(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
		Endereco enderecoDoBancoDeDados = this.service.buscaPorIdEndereco(id);
		BeanUtils.copyProperties(endereco, enderecoDoBancoDeDados, "id");
		this.service.save(enderecoDoBancoDeDados);
		return enderecoDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um novo endereço por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um novo endereço por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.deleteById(id);
	}
	
	@ApiOperation(
			value="Salva um novo endereço", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo endereço.")
	@PostMapping("/v1")
	public Endereco salvarv1(@RequestBody Endereco endereco) {
		return endereco;
	}
	@ApiOperation(
			value="Cadastra um novo endereço", 
			response=ResponseEntity.class, 
			notes="Essa operação cadastra um novo endereço.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> salvarv2(@RequestBody Endereco endereco) {
		return null;
	}
}
