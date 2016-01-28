package br.com.bought.dao;

import java.util.List;

import br.com.bought.model.Produto;

public interface ProdutoDAO {

	Produto obterPorCodigoBarra(String codigoBarra);
	List<Produto> listarTodos();
}
