package br.com.bought.common;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.bought.enums.StatusCompraENUM;

public class CompraVO {

	
	private StatusCompraENUM statusCompra;
	private CarrinhoVO carrinho;
	private BigDecimal valor;
	private Calendar dataGeracaoCompra;
	
	public StatusCompraENUM getStatusCompra() {
		return statusCompra;
	}
	public void setStatusCompra(StatusCompraENUM statusCompra) {
		this.statusCompra = statusCompra;
	}
	public CarrinhoVO getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(CarrinhoVO carrinho) {
		this.carrinho = carrinho;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Calendar getDataGeracaoCompra() {
		return dataGeracaoCompra;
	}
	public void setDataGeracaoCompra(Calendar dataGeracaoCompra) {
		this.dataGeracaoCompra = dataGeracaoCompra;
	}
	
}
