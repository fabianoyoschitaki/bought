package br.com.bought.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_ESTABELECIMENTO", unique = true, nullable = false, precision = 15, scale = 0)
	private Long id;
	
	@Column(name="CODIGO_ESTABELECIMENTO", unique=true)
	private String codigoEstabelecimento;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="NOME_CIDADE")
    private String nomeCidade;
	
	@Column(name="SIGLA_ESTADO")
    private String siglaEstado;
	
	@Column(name="NOME_LOGRADOURO")
    private String nomeLogradouro;
	
	@Column(name="NUMERO_LOGRADOURO")
    private String numeroLogradouro;
	
	@Column(name="TIPO_LOGRADOURO")
    private String tipoLogradouro;
	
	@Column(name="NUMERO_CEP")
    private String numeroCep;
	
	@Column(name="URL_LOGO")
    private String urlLogo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}