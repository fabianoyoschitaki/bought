package br.com.bought.common;

import java.util.Calendar;

public class CarrinhoVO {
	// número sessão
	private String numeroCarrinho;
	private Calendar dataCarrinho;
	private MercadoVO mercado;
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
}
