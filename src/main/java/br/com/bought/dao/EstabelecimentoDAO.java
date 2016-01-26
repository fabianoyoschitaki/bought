package br.com.bought.dao;

import java.util.List;

import br.com.bought.model.Estabelecimento;

public interface EstabelecimentoDAO {

	Estabelecimento obterEstabelecimentoPorId(Long id);
	Estabelecimento obterEstabelecimentoPorCodigoEstabelecimento(String codigoEstabelecimento);
	List<Estabelecimento> getTodosEstabelecimentos();
}
