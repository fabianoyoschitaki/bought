package br.com.bought.business;

import java.util.ArrayList;
import java.util.List;

import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.helper.EstabelecimentoHelper;
import br.com.bought.model.Estabelecimento;

public class EstabelecimentoBusiness {

	private EstabelecimentoDAOImpl estabelecimentoDAOImpl;
	private EstabelecimentoHelper estabelecimentoHelper;
	
	public EstabelecimentoBusiness(){
		estabelecimentoHelper = new EstabelecimentoHelper();
		estabelecimentoDAOImpl = new EstabelecimentoDAOImpl();
	}
	
	public Long salvar(EstabelecimentoVO estabelecimentoVO){
		Long retorno = null;
		if (estabelecimentoVO != null){
			Estabelecimento estabelecimento = estabelecimentoHelper.convertEstabelecimentoVOToEstabelecimento(estabelecimentoVO);
			retorno = estabelecimentoDAOImpl.salvar(estabelecimento);
		}
		return retorno;
	}
	
	
	public EstabelecimentoVO obterEstabelecimentoPorId(Long id){
		EstabelecimentoVO retorno = null;
		Estabelecimento estabelecimento = estabelecimentoDAOImpl.obterEstabelecimentoPorId(id);
		if(estabelecimento != null){
			retorno = estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento);
		}
		return retorno;
	}
	

	public EstabelecimentoVO obterEstabelecimentoPorCodigoEstabelecimento(String codigoEstabelecimento){
		EstabelecimentoVO retorno = null;
		Estabelecimento estabelecimento = estabelecimentoDAOImpl.obterEstabelecimentoPorCodigoEstabelecimento(codigoEstabelecimento);
		if (estabelecimento != null){
			retorno = estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento);
		}
		return retorno;
	}
	
	public EstabelecimentoVO obterEstabelecimentoPorQRCode(String qrCode){
		EstabelecimentoVO retorno = null;
		Estabelecimento estabelecimento = estabelecimentoDAOImpl.obterEstabelecimentoPorQRCode(qrCode);
		if(estabelecimento != null){
			retorno = estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento);
		}
		return retorno;
	}

	public List<EstabelecimentoVO> getTodosEstabelecimentos() {
		List<EstabelecimentoVO> retorno = new ArrayList<EstabelecimentoVO>();
		List<Estabelecimento> estabelecimentos = estabelecimentoDAOImpl.getTodosEstabelecimentos();
		if(estabelecimentos != null && estabelecimentos.size() > 0){
			for (Estabelecimento estabelecimento : estabelecimentos) {
				retorno.add(estabelecimentoHelper.convertEstabelecimentoToEstabelecimentoVO(estabelecimento));
			}
		}
		return retorno;
	}
}