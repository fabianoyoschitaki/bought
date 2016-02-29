package br.com.bought.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.helper.EstabelecimentoHelper;
import br.com.bought.model.Estabelecimento;

public class EstabelecimentoBusiness {

	private static final Logger LOOGER = 
		      Logger.getLogger(EstabelecimentoBusiness.class);
	
	private EstabelecimentoDAOImpl estabelecimentoDAOImpl;
	private EstabelecimentoHelper estabelecimentoHelper;
	
	public EstabelecimentoBusiness(){
		estabelecimentoHelper = new EstabelecimentoHelper();
		estabelecimentoDAOImpl = new EstabelecimentoDAOImpl();
	}
	
	public Long salvar(EstabelecimentoVO estabelecimentoVO){
		LOOGER.info("EstabelecimentoBusiness.salvar - INICIO");
		Long retorno = null;
		if (estabelecimentoVO != null){
			Estabelecimento estabelecimento = estabelecimentoHelper.convertEstabelecimentoVOToEstabelecimento(estabelecimentoVO);
			retorno = estabelecimentoDAOImpl.salvar(estabelecimento);
			if(retorno != null)
				LOOGER.info("ESTABELECIMENTO SALVO COM SUCESSO. "  + retorno);
		}
		LOOGER.info("EstabelecimentoBusiness.salvar - FIM");
		return retorno;
	}
	
	
	public EstabelecimentoVO obterEstabelecimentoPorId(Long id){
		LOOGER.info("EstabelecimentoBusiness.obterEstabelecimentoPorId - INICIO");
		EstabelecimentoVO retorno = null;
		Estabelecimento estabelecimento = estabelecimentoDAOImpl.obterEstabelecimentoPorId(id);
		if(estabelecimento != null){
			retorno = estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento);
		}
		LOOGER.info("EstabelecimentoBusiness.obterEstabelecimentoPorId - FIM");
		return retorno;
	}
	

	public EstabelecimentoVO obterEstabelecimentoPorCodigoEstabelecimento(String codigoEstabelecimento){
		LOOGER.info("EstabelecimentoBusiness.obterEstabelecimentoPorCodigoEstabelecimento - INICIO");
		EstabelecimentoVO retorno = null;
		Estabelecimento estabelecimento = estabelecimentoDAOImpl.obterEstabelecimentoPorCodigoEstabelecimento(codigoEstabelecimento);
		if (estabelecimento != null){
			retorno = estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento);
		}
		LOOGER.info("EstabelecimentoBusiness.obterEstabelecimentoPorCodigoEstabelecimento - FIM");
		return retorno;
	}


	public List<EstabelecimentoVO> getTodosEstabelecimentos() {
		LOOGER.info("EstabelecimentoBusiness.getTodosEstabelecimentos - INICIO");
		List<EstabelecimentoVO> retorno = new ArrayList<EstabelecimentoVO>();
		List<Estabelecimento> estabelecimentos = estabelecimentoDAOImpl.getTodosEstabelecimentos();
		if(estabelecimentos != null && estabelecimentos.size() > 0){
			LOOGER.info("ESTABELECIMENTOS ENCONTRADOS: " + estabelecimentos.size());
			for (Estabelecimento estabelecimento : estabelecimentos) {
				retorno.add(estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento));
			}
		}
		LOOGER.info("EstabelecimentoBusiness.getTodosEstabelecimentos - FIM");
		return retorno;
	}

	public Long inserirEstabelecimento(EstabelecimentoVO estabelecimentoVO) {
		LOOGER.info("EstabelecimentoBusiness.inserirEstabelecimento - INICIO");
		Estabelecimento estabelecimento = estabelecimentoHelper.convertEstabelecimentoVOToEstabelecimento(estabelecimentoVO);
		LOOGER.info("EstabelecimentoBusiness.inserirEstabelecimento - FIM");
		Long retorno = estabelecimentoDAOImpl.salvar(estabelecimento);
		if(retorno != null)
			LOOGER.info("ESTABELECIMENTO SALVO COM SUCESSO" + retorno);
		return retorno;
	}
}