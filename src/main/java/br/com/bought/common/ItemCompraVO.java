package br.com.bought.common;

import java.math.BigDecimal;

import br.com.bought.model.Produto;

/**
 * Created by Hallan on 06/12/2015.
 */
public class ItemCompraVO {

    private Produto produto;
    private Integer quantidade;
    private BigDecimal valorTotalItem;

    public ItemCompraVO(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotalItem = new BigDecimal(0);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotalItem() {
        if (produto != null && produto.getPreco() != null && quantidade != null){
            valorTotalItem = new BigDecimal(produto.getPreco() * quantidade);
        }
        return valorTotalItem;
    }
}
