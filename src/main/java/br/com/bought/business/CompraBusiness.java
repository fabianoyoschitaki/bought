package br.com.bought.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.CompraVO;
import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.ItemCompraVO;
import br.com.bought.common.ProdutoVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.CompraDAOImpl;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.enums.StatusCompraENUM;
import br.com.bought.model.Compra;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.Produto;
import br.com.bought.model.ItemCompra;
import br.com.bought.model.StatusCompra;
import br.com.bought.model.Usuario;

public class CompraBusiness {

	private CompraDAOImpl compraDAOImpl;
	private UsuarioDAOImpl usuarioDAOImpl;
	private EstabelecimentoDAOImpl estabelecimentoDAOImpl;

	public CompraBusiness() {
		compraDAOImpl = new CompraDAOImpl();
		usuarioDAOImpl = new UsuarioDAOImpl();
		estabelecimentoDAOImpl = new EstabelecimentoDAOImpl();
	}

	public CompraVO gerarCompra(String codigoEstabelecimento, UsuarioVO usuarioVO) {
		CompraVO retorno = null;
		if (codigoEstabelecimento != null && usuarioVO != null) {
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(usuarioVO.getEmail());
			Estabelecimento estabelecimento = estabelecimentoDAOImpl.
					obterEstabelecimentoPorCodigoEstabelecimento(codigoEstabelecimento);
			Compra compra = getCompra(usuario, estabelecimento);
			if (compra != null) {
				Long id = compraDAOImpl.salvar(compra);
				if (id != null) {
					retorno = convertToCompraVO(compra);
				}
			}
		}
		return retorno;
	}
	
	
	public CompraVO obterCompraPorId(Long id){
		CompraVO retorno = null;
		Compra compra = compraDAOImpl.buscarCompraPorId(id);
		if(compra != null){
			retorno = convertToCompraVO(compra);
		}
		return retorno;
	}

	private CompraVO convertToCompraVO(Compra compraGerada) {
		CompraVO compraVO = null;
		if (compraGerada != null) {
			compraVO = new CompraVO();
			compraVO.setId(compraGerada.getId());
			compraVO.setEstabelecimentoVO(convertToEstabelecimentoVO(compraGerada
					.getEstabelecimento()));
			compraVO.setItensCompraVO(getItensCompraVO(compraGerada
					.getItensCompra()));
			compraVO.setStatusCompraENUM(convertToStatusCompraENUM(compraGerada
					.getStatusCompra()));
			compraVO.setUsuarioVO(convertToUsuarioVO(compraGerada.getUsuario()));
			compraVO.setValorTotal(compraGerada.getValorTotal());
		}
		return compraVO;
	}

	private UsuarioVO convertToUsuarioVO(Usuario usuario) {
		UsuarioVO retorno = null;
		if (usuario != null) {
			retorno = new UsuarioVO();
			BeanUtils.copyProperties(usuario, retorno);
		}
		return retorno;
	}

	private StatusCompraENUM convertToStatusCompraENUM(StatusCompra statusCompra) {
		return StatusCompraENUM.get(statusCompra.getCodigo());
	}

	private List<ItemCompraVO> getItensCompraVO(List<ItemCompra> itensCompra) {
		List<ItemCompraVO> retorno = new ArrayList<ItemCompraVO>();
		if (itensCompra != null && itensCompra.size() > 0) {
			for (ItemCompra itemCompra : itensCompra) {
				retorno.add(convertToItemCompraVO(itemCompra));
			}
		}
		return retorno;
	}

	private ItemCompraVO convertToItemCompraVO(ItemCompra itemCompra) {
		ItemCompraVO retorno = null;
		if (itemCompra != null) {
			retorno = new ItemCompraVO();
			retorno.setId(itemCompra.getId());
			retorno.setProdutoVO(convertToProdutoVO(itemCompra.getProduto()));
			retorno.setQuantidade(itemCompra.getQuantidade());
			retorno.setValor(itemCompra.getValor());
		}
		return retorno;
	}

	private ProdutoVO convertToProdutoVO(Produto produto) {
		ProdutoVO retorno = null;
		if (produto != null) {
			retorno = new ProdutoVO();
			BeanUtils.copyProperties(produto, retorno);
		}
		return retorno;
	}

	private EstabelecimentoVO convertToEstabelecimentoVO(
			Estabelecimento estabelecimento) {
		EstabelecimentoVO retorno = null;
		if (estabelecimento != null) {
			retorno = new EstabelecimentoVO();
			BeanUtils.copyProperties(estabelecimento, retorno);
		}
		return retorno;
	}

	private Compra getCompra(Usuario usuario, Estabelecimento estabelecimento) {
		Compra retorno = null;
		try {
			retorno = new Compra();
			retorno.setItensCompra(new ArrayList<ItemCompra>());
			retorno.setStatusCompra(getStatusCompraInicial());
			retorno.setEstabelecimento(estabelecimento);
			retorno.setUsuario(usuario);
			retorno.setValorTotal(BigDecimal.ZERO);
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		}

		return retorno;
	}

	private Estabelecimento convertToEstabelecimentoVO(
			EstabelecimentoVO estabelecimentoVO) {
		Estabelecimento retorno = null;
		if(estabelecimentoVO != null){
			retorno = new Estabelecimento();
			BeanUtils.copyProperties(estabelecimentoVO, retorno);
		}
		return retorno;
	}


	private Produto convertToItem(ProdutoVO itemVO) {
		Produto item = null;
		if (itemVO != null) {
			item = new Produto();
			item.setCodigoBarra(itemVO.getCodigoBarra());
			item.setNome(itemVO.getNome());
			item.setUrlImagem(itemVO.getUrlImagem());
		}
		return item;
	}

	private BigDecimal getValorTotal(List<ItemCompraVO> itens) {
		BigDecimal retorno = BigDecimal.ZERO;
		if (itens != null && itens.size() > 0) {
			for (ItemCompraVO itemCompraVO : itens) {
				if (itemCompraVO != null && itemCompraVO.getValor() != null
						&& itemCompraVO.getQuantidade() != null) {
					retorno = retorno.add(itemCompraVO.getValor().multiply(
					new BigDecimal(itemCompraVO.getQuantidade())));
				}
			}
		}
		return retorno;
	}

	private Usuario convertToUsuario(UsuarioVO usuarioVO) {
		Usuario retorno = null;
		if (usuarioVO != null) {
			retorno = new Usuario();
			retorno.setNome(usuarioVO.getNome());
			retorno.setEmail(usuarioVO.getEmail());
			retorno.setSenha(usuarioVO.getSenha());
			retorno.setDataCriacao(usuarioVO.getDataCriacao());
		}
		return retorno;
	}

	private StatusCompra getStatusCompraInicial() {
		StatusCompra retorno = new StatusCompra();
		retorno.setCodigo(StatusCompraENUM.AGUARDANDO_PAGAMENTO.getCodigo());
		retorno.setDescricao(StatusCompraENUM.AGUARDANDO_PAGAMENTO
				.getDescricao());
		return retorno;
	}
	
	private StatusCompra getStatusCompraFinalizado() {
		StatusCompra retorno = new StatusCompra();
		retorno.setCodigo(StatusCompraENUM.FINALIZADO.getCodigo());
		retorno.setDescricao(StatusCompraENUM.FINALIZADO
				.getDescricao());
		return retorno;
	}

	public CompraVO finalizarCompra(CompraVO compraVO) {
		CompraVO retorno = null;
		if(compraVO != null){
			Compra compra = convertCompraVOToCompra(compraVO);
			if(compra != null){
				compra.setStatusCompra(getStatusCompraFinalizado());
				if(compraDAOImpl.update(compra)){
					retorno = convertToCompraVO(compra);
				}
			}
		}
		return retorno;
	}

	private Compra convertCompraVOToCompra(CompraVO compraVO) {
		Compra retorno = null;
		if(compraVO != null){
			retorno = new Compra();
			retorno.setId(compraVO.getId());
			retorno.setNumeroSessao(compraVO.getNumeroSessao());
			retorno.setItensCompra(getItensCompraFromItensCompraVO(compraVO.getItensCompraVO()));
			retorno.setEstabelecimento(getEstabelecimentoFromEstabelecimentoVO(compraVO.getEstabelecimentoVO()));
			retorno.setUsuario(getUsuarioFromUsuarioVO(compraVO.getUsuarioVO()));
			retorno.setValorTotal(compraVO.getValorTotal());
		}
		return retorno;
	}

	private Usuario getUsuarioFromUsuarioVO(UsuarioVO usuarioVO) {
		Usuario retorno = null;
		if(usuarioVO != null){
			retorno = new Usuario();
			BeanUtils.copyProperties(usuarioVO, retorno);
		}
		return retorno;
	}

	private Estabelecimento getEstabelecimentoFromEstabelecimentoVO(
			EstabelecimentoVO estabelecimentoVO) {
		Estabelecimento retorno = null;
		if(estabelecimentoVO != null){
			retorno = new Estabelecimento();
			BeanUtils.copyProperties(estabelecimentoVO, retorno);
		}
		return retorno;
	}

	private List<ItemCompra> getItensCompraFromItensCompraVO(
			List<ItemCompraVO> itensCompraVO) {
		List<ItemCompra> retorno = null;
		if(itensCompraVO != null && itensCompraVO.size() > 0){
			retorno = new ArrayList<ItemCompra>();
			for (ItemCompraVO itemCompraVO : itensCompraVO) {
				retorno.add(convertToItemCompra(itemCompraVO));
			}
		} 
		return retorno;
	}

	private ItemCompra convertToItemCompra(ItemCompraVO itemCompraVO) {
		ItemCompra retorno = null;
		if(itemCompraVO != null){
			retorno = new ItemCompra();
			BeanUtils.copyProperties(itemCompraVO, retorno);
		}
		return retorno;
	}

}