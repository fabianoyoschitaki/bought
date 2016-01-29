package br.com.bought.helper;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.ProdutoVO;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.Produto;

public class ProdutoHelper {

	public EstabelecimentoVO convertEstabelecimentoToEstabelecimentoVO(
			Estabelecimento estabelecimento) {
		EstabelecimentoVO retorno = null;
		if(estabelecimento != null){
			retorno = new EstabelecimentoVO();
			BeanUtils.copyProperties(estabelecimento, retorno);
		}
		return retorno;
	}
	
	public Estabelecimento convertEstabelecimentoVOToEstabelecimento(EstabelecimentoVO estabelecimentoVO){
		Estabelecimento retorno = null;
		if(estabelecimentoVO != null){
			retorno = new Estabelecimento();
			BeanUtils.copyProperties(estabelecimentoVO, retorno);
		}
		return retorno;
	}

	public ProdutoVO convertProdutoToProdutoVO(Produto produto) {
		ProdutoVO retorno = null;
		if(produto != null){
			retorno = new ProdutoVO();
			BeanUtils.copyProperties(produto, retorno);
		}
		return retorno;
	}

	public Produto convertProdutoVOToProduto(ProdutoVO produtoVO) {
		Produto retorno = null;
		if(produtoVO != null){
			retorno = new Produto();
			BeanUtils.copyProperties(produtoVO, retorno);
		}
		return retorno;
	}
}
