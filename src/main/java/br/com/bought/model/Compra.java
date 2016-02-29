package br.com.bought.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_COMPRA")
	private Long id;
	
	@Column(name="NUMERO_SESSAO")
	private String numeroSessao;
	
	@Column(name="DATA")
	private Date data;
	
	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	@OneToOne
	@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_ESTABELECIMENTO", referencedColumnName="ID_ESTABELECIMENTO")
	private Estabelecimento estabelecimento;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ItemCompra> itensCompra;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "CODIGO_STATUS_COMPRA")
	private StatusCompra statusCompra;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusCompra getStatusCompra() {
		return statusCompra;
	}
	public void setStatusCompra(StatusCompra statusCompra) {
		this.statusCompra = statusCompra;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
	public String getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(String numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
