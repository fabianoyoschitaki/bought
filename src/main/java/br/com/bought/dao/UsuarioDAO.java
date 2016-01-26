package br.com.bought.dao;

import java.util.List;

import br.com.bought.model.Usuario;

public interface UsuarioDAO {

	Usuario buscarPorId(Long id);
	Usuario obterUsuarioPorEmail(String email);
	Long salvar(Usuario usuario);
	List<Usuario> listarTodos();
}
