package br.com.bought.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 15, scale = 0)
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL", unique=true)
	private String email;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
