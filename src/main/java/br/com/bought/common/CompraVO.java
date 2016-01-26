package br.com.bought.common;

import java.math.BigDecimal;
import java.util.List;

import br.com.bought.enums.StatusCompraENUM;

public class CompraVO {

	private BigDecimal valorTotal;
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
}
