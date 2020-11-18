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

import br.com.distribuidora.mode.Usuario;
import br.com.distribuidora.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/usuario/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@ApiOperation(
			value="Lista um usuário novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do usuário.")
	@GetMapping("/v1")
	public List<Usuario> listarv1() {
		System.out.println("Chamando a versão 1");
		return null;
	}
	@ApiOperation(
			value="Lista um usuário novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do usuário.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Usuario>> Listarv2() {
		return null;
		
	}
	@ApiOperation(
			value="Remove um usuário novo por ID", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um novo usuário por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}

	@ApiOperation(
			value="Salva um usuário novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do usuário.")
	@PostMapping("/v1")
	public Usuario salvarv1(@RequestBody Usuario usuario) {
		return null;
	}
	@ApiOperation(
			value="Cadastra um usuário novo.",
			response=ResponseEntity.class, 
			notes="Essa operação cadastra um novo registro com as informações do usuario.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvarv2(@RequestBody Usuario usuario) {
		return null;
}
}