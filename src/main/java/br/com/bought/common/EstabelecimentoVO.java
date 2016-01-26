package br.com.bought.common;



public class EstabelecimentoVO {

	private String codigoEstabelecimento;
	private String descricao;
	private String nome;
    private String nomeCidade;
    private String siglaEstado;
    private String nomeLogradouro;
    private String numeroLogradouro;
    private String tipoLogradouro;
    private String numeroCep;
    private String urlLogo;
    private String qrCode;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}
	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}
	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getNumeroCep() {
		return numeroCep;
	}
	public void setNumeroCep(String numeroCep) {
		this.numeroCep = numeroCep;
	}
	
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(String codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}