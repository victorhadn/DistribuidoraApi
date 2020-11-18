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

import br.com.distribuidora.mode.Produto;
import io.swagger.annotations.ApiOperation;
import br.com.distribuidora.Services.ProdutoService;


@RestController
@RequestMapping("/produtos/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@ApiOperation(
			value="Lista um produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do produto.")
	@GetMapping("/v1")
	public List<Produto> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarProdutos();
	}
	@ApiOperation(
			value="Lista um produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do produto.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Produto>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarProdutos());
	}
	@ApiOperation(
			value="Busca um produto novo por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um novo registro por ID.")
	@PutMapping("/{id}")
	public Produto editar(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Produto produtoDoBancoDeDados = this.service.buscaPorIdProduto(id);
		BeanUtils.copyProperties(produto, produtoDoBancoDeDados, "id");
		this.service.salvar(produtoDoBancoDeDados);
		return produtoDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um produto novo por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um produto por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdProduto(id));
	}
	@ApiOperation(
			value="Salva um produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do produto.")
	@PostMapping("/v1")
	public Produto salvarv1(@RequestBody Produto produto) {
		return this.service.salvar(produto);
	}
	@ApiOperation(
			value="Cadastra um produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação cadastra um novo registro com as informações do produto.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> salvarv2(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(this.service.salvar(produto));
}
}

