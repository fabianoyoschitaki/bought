package br.com.bought.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STATUS_COMPRA")
public class StatusCompra {

	@Id
	@Column(name="CODIGO", unique=true)
	private Short codigo;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	
	public Short getCodigo() {
		return codigo;
	}
	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
