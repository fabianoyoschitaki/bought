package br.com.bought.dao;

import java.util.List;

import br.com.bought.model.Compra;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.Usuario;

public interface CompraDAO {

	Long salvar(Compra compra);
	List<Compra> obterComprasPorUsuario(Usuario usuario, Estabelecimento estabelecimento);
	Compra buscarCompraPorId(Long id);
	Boolean excluirCompra(Compra compra);
}
