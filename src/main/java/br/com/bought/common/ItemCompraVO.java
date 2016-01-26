package br.com.bought.common;

import java.math.BigDecimal;


/**
 * Created by Hallan on 06/12/2015.
 */
public class ItemCompraVO {

    private ItemVO itemVO;
    private Integer quantidade;
    private BigDecimal valor;

    public ItemCompraVO(ItemVO itemVO, Integer quantidade, BigDecimal valor){
    	this.itemVO = itemVO;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ItemCompraVO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}
}
