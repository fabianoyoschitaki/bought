package br.com.bought.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ATIVACAO_CADASTRO_USUARIO")
public class AtivacaoCadastroUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
	private Usuario usuario;
	
	@Column(name="CHAVE_CONFIRMACAO_CADASTRO")
	private String chaveConfirmacao;
	
	
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
	public String getChaveConfirmacao() {
		return chaveConfirmacao;
	}
	public void setChaveConfirmacao(String chaveConfirmacao) {
		this.chaveConfirmacao = chaveConfirmacao;
	}
}
