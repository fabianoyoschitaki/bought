package br.com.bought.enums;

public enum StatusCompraENUM {

	PAGA(1,"PAGA"),
	AGUARDANDO_PAGAMENTO(2,"AGUARDANDO PAGAMENTO"),
	CANCELADO(3, "CANCELADO"),
	RECUSADA(4, "RECUSADA");
	
	private Integer codigo;
	private String descricao;
	
	StatusCompraENUM(final Integer codigo, final String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
