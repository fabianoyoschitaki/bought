package br.com.bought.common;

import java.util.List;

public class CarrinhoVO {
	// número sessão
	private String numeroCarrinho;
	private EstabelecimentoVO estabelecimentoVO;
	private List<ItemCompraVO> itensCompraVO;

	public String getNumeroCarrinho() {
		return numeroCarrinho;
	}
	public void setNumeroCarrinho(String numeroCarrinho) {
		this.numeroCarrinho = numeroCarrinho;
	}
	public EstabelecimentoVO getEstabelecimentoVO() {
		return estabelecimentoVO;
	}
	public void setEstabelecimentoVO(EstabelecimentoVO estabelecimentoVO) {
		this.estabelecimentoVO = estabelecimentoVO;
	}
	public List<ItemCompraVO> getItensCompraVO() {
		return itensCompraVO;
	}
	public void setItensCompraVO(List<ItemCompraVO> itensCompraVO) {
		this.itensCompraVO = itensCompraVO;
	}
}
