package br.com.bought.business;

import java.util.ArrayList;
import java.util.UUID;

import br.com.bought.common.CarrinhoVO;
import br.com.bought.common.ItemCompraVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.helper.EstabelecimentoHelper;

public class CarrinhoBusiness {

	private UsuarioBusiness usuarioBusiness;
	private EstabelecimentoBusiness estabelecimentoBusiness;

	public CarrinhoBusiness() {
		estabelecimentoBusiness = new EstabelecimentoBusiness();
		usuarioBusiness = new UsuarioBusiness();
	}

	public CarrinhoVO getNovoCarrinho(String codigoEstabelecimento,
			UsuarioVO usuarioVO) {
		CarrinhoVO retorno = null;
		if (codigoEstabelecimento != null && usuarioBusiness.isUsuarioValido(usuarioVO)) {
			retorno = new CarrinhoVO();
			retorno.setEstabelecimentoVO(estabelecimentoBusiness.obterEstabelecimentoPortCodigoEstabelecimento(codigoEstabelecimento));
			retorno.setItensCompraVO(new ArrayList<ItemCompraVO>());
			retorno.setNumeroCarrinho(getNumeroCarrinho(codigoEstabelecimento, usuarioVO));
		}
		return retorno;
	}

	private String getNumeroCarrinho(String codigoEstabelecimento,
			UsuarioVO usuarioVO) {
		// TODO GERAR O NUMERO DO CARRINHO..A SESSAO..
		return UUID.randomUUID().toString();
	}

	public boolean isCarrinhoValido(CarrinhoVO carrinho) {
		Boolean retorno = Boolean.FALSE;
		if (carrinho != null) {
			//TODO IMPLEMENTAR REGRAS DE VALIDAÇÃO DO CARRINHO..
			retorno = Boolean.TRUE;
		}
		return retorno;
	}
}