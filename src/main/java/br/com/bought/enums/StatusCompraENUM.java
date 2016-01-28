package br.com.bought.enums;

public enum StatusCompraENUM {

	PAGA((short)1,"PAGA"),
	AGUARDANDO_PAGAMENTO((short)2,"AGUARDANDO PAGAMENTO"),
	CANCELADO((short)3, "CANCELADO"),
	RECUSADA((short)4, "RECUSADA"),
	FINALIZADO((short)4, "FINALIZADO");
	
	private Short codigo;
	private String descricao;
	
	public static StatusCompraENUM get(Short codigo){
		StatusCompraENUM retorno = null;
		for (StatusCompraENUM statusCompraEnum : values()) {
			if(statusCompraEnum.getCodigo().equals(codigo)){
				retorno = statusCompraEnum;
			}
		}
		return retorno;
	}
	
	StatusCompraENUM(final Short codigo, final String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

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
