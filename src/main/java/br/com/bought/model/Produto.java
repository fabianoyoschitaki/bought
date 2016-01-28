package br.com.bought.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2466419190000434186L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_PRODUTO", unique = true, nullable = false, precision = 15, scale = 0)
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CODIGO_BARRA")
	private String codigoBarra;
	
	@Column(name="URL_IMAGEM")
	private String urlImagem;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ITEM_COMPRA",referencedColumnName="ID_ITEM_COMPRA")
	private ItemCompra itemCompra;
	
	
	//private Categoria categoria;
	
	//private Marca marca;
	
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//
//	public Marca getMarca() {
//		return marca;
//	}
//
//	public void setMarca(Marca marca) {
//		this.marca = marca;
//	}


	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public ItemCompra getItemCompra() {
		return itemCompra;
	}
	public void setItemCompra(ItemCompra itemCompra) {
		this.itemCompra = itemCompra;
	}
}
