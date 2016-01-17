package br.com.bought.common;

import java.util.Calendar;
import java.util.List;

import br.com.bought.enums.StatusCarrinhoENUM;

public class CarrinhoVO {
	// número sessão
	private String numeroCarrinho;
	private Calendar dataCarrinho;
	private MercadoVO mercado;
	private StatusCarrinhoENUM statusCarrinho;
	private List<ItemCompraVO> itens;
	
	
	public String getNumeroCarrinho() {
		return numeroCarrinho;
	}
	public void setNumeroCarrinho(String numeroCarrinho) {
		this.numeroCarrinho = numeroCarrinho;
	}
	public Calendar getDataCarrinho() {
		return dataCarrinho;
	}
	public void setDataCarrinho(Calendar dataCarrinho) {
		this.dataCarrinho = dataCarrinho;
	}
	public MercadoVO getMercado() {
		return mercado;
	}
	public void setMercado(MercadoVO mercado) {
		this.mercado = mercado;
	}
	public StatusCarrinhoENUM getStatusCarrinho() {
		return statusCarrinho;
	}
	public void setStatusCarrinho(StatusCarrinhoENUM statusCarrinho) {
		this.statusCarrinho = statusCarrinho;
	}
	public List<ItemCompraVO> getItens() {
		return itens;
	}
	public void setItens(List<ItemCompraVO> itens) {
		this.itens = itens;
	}
}
