package br.com.distribuidora.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.distribuidora.mode.Usuario;
import br.com.distribuidora.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return this.repository.save(usuario);
		
	}
	

	@Override
	public List<Usuario> listarUsuarios() {
		return this.repository.findAll();
	}
	
	@Override
	@Transactional
	public void removerPorUsuario(Usuario usuario) {
		this.repository.delete(usuario);
		
	}
	

	@Override
	@Transactional
	public void removerPorId(Long id) {
		this.repository.deleteById(id);

	}


	@Override
	public Usuario buscaPorIdUsuario(Long id) {
		this.repository.findById(id);
		return null;
		
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(Usuario usuarioDoBancoDeDados) {
		// TODO Auto-generated method stub
		
	}

}