package br.com.bought.helper;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.model.Estabelecimento;

public class EstabelecimentoHelper {

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
}
