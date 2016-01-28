package br.com.bought.business;

import java.util.UUID;

import br.com.bought.common.UsuarioVO;

public class CarrinhoBusiness {

	private UsuarioBusiness usuarioBusiness;
	private EstabelecimentoBusiness estabelecimentoBusiness;

	public CarrinhoBusiness() {
		estabelecimentoBusiness = new EstabelecimentoBusiness();
		usuarioBusiness = new UsuarioBusiness();
	}


	private String getNumeroCarrinho(String codigoEstabelecimento,
			UsuarioVO usuarioVO) {
		// TODO GERAR O NUMERO DO CARRINHO..A SESSAO..
		return UUID.randomUUID().toString();
	}
}