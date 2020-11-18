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

import br.com.distribuidora.Services.FornecedorService;
import br.com.distribuidora.mode.Fornecedor;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/fornecedor/api")
public class FornecedorController {

	@Autowired
	private FornecedorService service;

	@ApiOperation(
			value="Lista um fornecedor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do fornecedor.")
	@GetMapping("/v1")
	public List<Fornecedor> listarv1() {
		System.out.println("Chamando a versão 1");
		return null;
	}
	@ApiOperation(
			value="Lista um fornecedor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do fornecedor.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Fornecedor>> Listarv2() {
		return null;

	}

	@ApiOperation(
			value="Busca um fornecedor novo por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo fornecedor por ID.")
	@PutMapping("/{id}")
	public Fornecedor editar(@PathVariable("id") Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorDoBancoDeDados = this.service.findById(id);
		BeanUtils.copyProperties(fornecedor, fornecedorDoBancoDeDados, "id");
		this.service.save(fornecedorDoBancoDeDados);
		return fornecedorDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um fornecedor por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um fornecedor por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.deleteById(id);
	}

	@ApiOperation(
			value="Salva um fornecedor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do fornecedor.")
	@PostMapping("/v1")
	public Fornecedor salvarv1(@RequestBody Fornecedor fornecedor) {
		return null;
	}
	@ApiOperation(
			value="Salva um fornecedor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do fornecedor.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> salvarv2(@RequestBody Fornecedor fornecedor) {
		return null;
}
}