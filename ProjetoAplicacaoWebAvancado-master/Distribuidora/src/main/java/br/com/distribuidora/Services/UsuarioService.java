package br.com.distribuidora.Services;

import java.util.List;

import br.com.distribuidora.mode.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);

	List<Usuario> listarUsuarios();

	void removerPorUsuario(Usuario usuario);

	void removerPorId(Long id);

	void deleteById(Long id);

	Usuario findById(Long id);

	void save(Usuario usuarioDoBancoDeDados);

	Usuario buscaPorIdUsuario(Long id);
	
	


}