package br.com.bought.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.CarrinhoVO;
import br.com.bought.common.CompraVO;
import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.ItemCompraVO;
import br.com.bought.common.ItemVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.CompraDAOImpl;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.enums.StatusCompraENUM;
import br.com.bought.model.Compra;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.Item;
import br.com.bought.model.ItemCompra;
import br.com.bought.model.StatusCompra;
import br.com.bought.model.Usuario;

public class CompraBusiness {

	private CompraDAOImpl compraDAOImpl;
	private UsuarioDAOImpl usuarioDAOImpl;
	private EstabelecimentoDAOImpl estabelecimentoDAOImpl;
	private CarrinhoBusiness carrinhoBusiness;

	public CompraBusiness() {
		carrinhoBusiness = new CarrinhoBusiness();
		compraDAOImpl = new CompraDAOImpl();
		usuarioDAOImpl = new UsuarioDAOImpl();
		estabelecimentoDAOImpl = new EstabelecimentoDAOImpl();
	}

	public CompraVO gerarCompra(CarrinhoVO carrinho, UsuarioVO usuarioVO) {
		CompraVO retorno = null;
		if (carrinhoBusiness.isCarrinhoValido(carrinho) && usuarioVO != null) {
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(usuarioVO.getEmail());
			Estabelecimento estabelecimento = estabelecimentoDAOImpl.
					obterEstabelecimentoPorCodigoEstabelecimento(carrinho.getEstabelecimentoVO().getCodigoEstabelecimento());
			Compra compra = getCompra(carrinho, usuario, estabelecimento);
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
			retorno.setEmail(usuario.getEmail());
			retorno.setNome(usuario.getNome());
			retorno.setSenha(usuario.getSenha());
			retorno.setDataCriacao(usuario.getDataCriacao());
		}
		return retorno;
	}

	private StatusCompraENUM convertToStatusCompraENUM(StatusCompra statusCompra) {
		return StatusCompraENUM.get(statusCompra.getCodigo());
	}

	private List<ItemCompraVO> getItensCompraVO(List<ItemCompra> itensCompra) {
		List<ItemCompraVO> retorno = null;
		if (itensCompra != null && itensCompra.size() > 0) {
			retorno = new ArrayList<ItemCompraVO>();
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
			retorno.setItemVO(convertToItemVO(itemCompra.getItem()));
			retorno.setQuantidade(itemCompra.getQuantidade());
			retorno.setValor(itemCompra.getValor());
		}
		return retorno;
	}

	private ItemVO convertToItemVO(Item item) {
		ItemVO retorno = null;
		if (item != null) {
			retorno = new ItemVO();
			retorno.setCodigoBarra(item.getCodigoBarra());
			retorno.setNome(item.getNome());
			retorno.setUrlImagem(item.getUrlImagem());
		}
		return retorno;
	}

	private EstabelecimentoVO convertToEstabelecimentoVO(
			Estabelecimento estabelecimento) {
		EstabelecimentoVO retorno = null;
		if (estabelecimento != null) {
			retorno = new EstabelecimentoVO();
			retorno.setCodigoEstabelecimento(estabelecimento
					.getCodigoEstabelecimento());
			retorno.setDescricao(estabelecimento.getDescricao());
		}
		return retorno;
	}

	private Compra getCompra(CarrinhoVO carrinho, Usuario usuario, Estabelecimento estabelecimento) {
		Compra retorno = null;
		try {
			retorno = new Compra();
			retorno.setItensCompra(convertToItensCompra(carrinho));
			retorno.setStatusCompra(getStatusCompraInicial());
			retorno.setEstabelecimento(estabelecimento);
			retorno.setUsuario(usuario);
			retorno.setValorTotal(getValorTotal(carrinho.getItensCompraVO()));
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

	private List<ItemCompra> convertToItensCompra(CarrinhoVO carrinhoVO) {
		List<ItemCompra> retorno = new ArrayList<ItemCompra>();
		List<ItemCompraVO> itensVO = carrinhoVO.getItensCompraVO();
		if (itensVO != null && itensVO.size() > 0) {
			for (ItemCompraVO itemCompraVO : itensVO) {
				if (itemCompraVO != null) {
					retorno.add(convertToItemCompra(carrinhoVO, itemCompraVO));
				}
			}
		}
		return retorno;
	}

	private ItemCompra convertToItemCompra(CarrinhoVO carrinhoVO,
			ItemCompraVO itemCompraVO) {
		ItemCompra retorno = null;
		if (itemCompraVO != null && itemCompraVO.getItemVO() != null) {
			retorno = new ItemCompra();
			retorno.setQuantidade(itemCompraVO.getQuantidade());
			retorno.setItem(convertToItem(itemCompraVO.getItemVO()));
			retorno.setValor(itemCompraVO.getValor());
		}
		return retorno;
	}

	private Item convertToItem(ItemVO itemVO) {
		Item item = null;
		if (itemVO != null) {
			item = new Item();
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

}