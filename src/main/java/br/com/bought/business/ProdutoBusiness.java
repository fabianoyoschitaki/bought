package br.com.bought.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.ProdutoVO;
import br.com.bought.dao.ProdutoDAOImpl;
import br.com.bought.helper.ProdutoHelper;
import br.com.bought.model.Produto;

public class ProdutoBusiness {

	private ProdutoHelper produtoHelper;
	private ProdutoDAOImpl produtoDAOImpl;
	public ProdutoBusiness() {
		produtoHelper = new ProdutoHelper();
		produtoDAOImpl = new ProdutoDAOImpl();
	}


	public ProdutoVO obterPorCodigoBarra(String codigoBarra){
		ProdutoVO retorno = null;
		Produto produto = produtoDAOImpl.obterPorCodigoBarra(codigoBarra);
		if(produto != null){
			retorno = new ProdutoVO();
			BeanUtils.copyProperties(produto, retorno);
		}
		return retorno;
	}


	public List<ProdutoVO> listarTodos() {
		List<ProdutoVO> retorno = null;
		List<Produto> produtos = produtoDAOImpl.listarTodos();
		if(produtos != null && produtos.size() > 0){
			retorno = new ArrayList<ProdutoVO>();
			for (Produto produto : produtos) {
				retorno.add(produtoHelper.convertProdutoToProdutoVO(produto));
			}
		}
		return retorno;
	}
}