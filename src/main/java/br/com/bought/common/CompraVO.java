package br.com.bought.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.bought.enums.StatusCompraENUM;

public class CompraVO {

	private Long id;
	private String numeroSessao;
	private BigDecimal valorTotal;
	private Date data;
	private UsuarioVO usuarioVO;
	private EstabelecimentoVO estabelecimentoVO;
	private List<ItemCompraVO> itensCompraVO;
	private StatusCompraENUM statusCompraENUM;
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	public EstabelecimentoVO getEstabelecimentoVO() {
		return estabelecimentoVO;
	}
	public void setEstabelecimentoVO(EstabelecimentoVO estabelecimentoVO) {
		this.estabelecimentoVO = estabelecimentoVO;
	}
	public List<ItemCompraVO> getItensCompraVO() {
		return itensCompraVO;
	}
	public void setItensCompraVO(List<ItemCompraVO> itensCompraVO) {
		this.itensCompraVO = itensCompraVO;
	}
	public StatusCompraENUM getStatusCompraENUM() {
		return statusCompraENUM;
	}
	public void setStatusCompraENUM(StatusCompraENUM statusCompraENUM) {
		this.statusCompraENUM = statusCompraENUM;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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