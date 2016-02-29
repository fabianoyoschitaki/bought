package br.com.bought.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import br.com.bought.common.ProdutoVO;
import br.com.bought.dao.ProdutoDAOImpl;
import br.com.bought.helper.ProdutoHelper;
import br.com.bought.model.Produto;

public class ProdutoBusiness {

	private static final Logger LOOGER = 
		      Logger.getLogger(ProdutoBusiness.class);
	
	private ProdutoHelper produtoHelper;
	private ProdutoDAOImpl produtoDAOImpl;
	public ProdutoBusiness() {
		produtoHelper = new ProdutoHelper();
		produtoDAOImpl = new ProdutoDAOImpl();
	}


	public ProdutoVO obterPorCodigoBarra(String codigoBarra){
		LOOGER.info("ProdutoBusiness.obterPorCodigoBarra - INICIO");
		LOOGER.info("CODIGOBARRA: " + codigoBarra);
		ProdutoVO retorno = null;
		Produto produto = produtoDAOImpl.obterPorCodigoBarra(codigoBarra);
		if(produto != null){
			retorno = new ProdutoVO();
			BeanUtils.copyProperties(produto, retorno);
		}
		LOOGER.info("ProdutoBusiness.obterPorCodigoBarra - FIM");
		return retorno;
	}


	public Long salvar(ProdutoVO produtoVO){
		LOOGER.info("ProdutoBusiness.salvar - INICIO");
		Long retorno = null;
		Produto produto = produtoHelper.convertProdutoVOToProduto(produtoVO);
		retorno = produtoDAOImpl.salvar(produto);
		LOOGER.info("ProdutoBusiness.salvar - FIM");
		return retorno;
	}
	
	public List<ProdutoVO> listarTodos() {
		LOOGER.info("ProdutoBusiness.listarTodos - INICIO");
		List<ProdutoVO> retorno = null;
		List<Produto> produtos = produtoDAOImpl.listarTodos();
		if(produtos != null && produtos.size() > 0){
			retorno = new ArrayList<ProdutoVO>();
			for (Produto produto : produtos) {
				retorno.add(produtoHelper.convertProdutoToProdutoVO(produto));
			}
		}
		LOOGER.info("ProdutoBusiness.listarTodos - INICIO");
		return retorno;
	}
}