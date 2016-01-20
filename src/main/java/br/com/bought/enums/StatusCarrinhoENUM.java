package br.com.bought.enums;

public enum StatusCarrinhoENUM {

	EM_COMPRAS(1,"EM COMPRAS"),
	FINALIZADO(2,"FINALIZADO");
	
	private Integer codigo;
	private String descricao;
	
	private StatusCarrinhoENUM(final Integer codigo, final String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
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
