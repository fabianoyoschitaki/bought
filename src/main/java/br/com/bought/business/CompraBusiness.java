package br.com.bought.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.bought.common.CompraVO;
import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.CompraDAOImpl;
import br.com.bought.dao.EstabelecimentoDAOImpl;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.enums.StatusCompraENUM;
import br.com.bought.helper.CompraHelper;
import br.com.bought.helper.EstabelecimentoHelper;
import br.com.bought.helper.UsuarioHelper;
import br.com.bought.model.Compra;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.ItemCompra;
import br.com.bought.model.StatusCompra;
import br.com.bought.model.Usuario;

public class CompraBusiness {

	private static final Logger LOOGER = 
		      Logger.getLogger(CompraBusiness.class);
	
	private CompraDAOImpl compraDAOImpl;
	private UsuarioDAOImpl usuarioDAOImpl;
	private EstabelecimentoDAOImpl estabelecimentoDAOImpl;
	private UsuarioBusiness usuarioBusiness;
	private EstabelecimentoBusiness estabelecimentoBusiness;
	private UsuarioHelper usuarioHelper;
	private CompraHelper compraHelper;
	private EstabelecimentoHelper estabelecimentoHelper;
	
	public CompraBusiness() {
		usuarioBusiness = new UsuarioBusiness();
		usuarioHelper = new UsuarioHelper();
		compraHelper = new CompraHelper();
		compraDAOImpl = new CompraDAOImpl();
		usuarioDAOImpl = new UsuarioDAOImpl();
		estabelecimentoDAOImpl = new EstabelecimentoDAOImpl();
		estabelecimentoHelper = new EstabelecimentoHelper();
		estabelecimentoBusiness = new EstabelecimentoBusiness();
	}

	public List<CompraVO> obterComprasPorCpf(String cpf, Long idEstabelecimento){
		List<CompraVO> retorno = new ArrayList<CompraVO>();
		if(cpf != null){
			UsuarioVO usuarioVO = usuarioBusiness.obterUsuarioPorCpf(cpf);
			EstabelecimentoVO estabelecimentoVO = estabelecimentoBusiness.obterEstabelecimentoPorId(idEstabelecimento);
			if(usuarioVO != null && estabelecimentoVO != null){
				Usuario usuario = usuarioHelper.convertUsuarioVOToUsuario(usuarioVO);
				Estabelecimento estabelecimento = estabelecimentoHelper.convertEstabelecimentoVOToEstabelecimento(estabelecimentoVO);
				List<Compra> compras = compraDAOImpl.obterComprasPorUsuario(usuario, estabelecimento);
				if(compras != null && compras.size() > 0){
					for (Compra compra : compras) {
						retorno.add(compraHelper.convertToCompraVO(compra));
					}
				}
			}
		}
		return retorno;
	}
	
	public CompraVO gerarCompra(String codigoEstabelecimento, UsuarioVO usuarioVO) {
		LOOGER.info("CompraBusiness.gerarCompra - INICIO");
		LOOGER.info("CODIGOESTABELECIMENTO: "+codigoEstabelecimento);
		CompraVO retorno = null;
		if (codigoEstabelecimento != null && usuarioVO != null) {
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(usuarioVO.getEmail());
			Estabelecimento estabelecimento = estabelecimentoDAOImpl.
					obterEstabelecimentoPorCodigoEstabelecimento(codigoEstabelecimento);
			Compra compra = getCompra(usuario, estabelecimento);
			if (compra != null) {
				Long id = compraDAOImpl.salvar(compra);
				LOOGER.info("Compra gerada com sucesso." + id);
				if (id != null) {
					retorno = compraHelper.convertToCompraVO(compra);
				}
			}
		}
		LOOGER.info("CompraBusiness.gerarCompra - FIM");
		return retorno;
	}
	
	
	public CompraVO obterCompraPorId(Long id){
		LOOGER.info("CompraBusiness.obterCompraPorId - INICIO");
		LOOGER.info("ID:" + id);
		CompraVO retorno = null;
		Compra compra = compraDAOImpl.buscarCompraPorId(id);
		if(compra != null){
			retorno = compraHelper.convertToCompraVO(compra);
		}
		LOOGER.info("CompraBusiness.obterCompraPorId - FIM");
		return retorno;
	}

	private Compra getCompra(Usuario usuario, Estabelecimento estabelecimento) {
		Compra retorno = null;
		try {
			retorno = new Compra();
			retorno.setData(new Date());
			retorno.setItensCompra(new ArrayList<ItemCompra>());
			retorno.setStatusCompra(getStatusCompraInicial());
			retorno.setEstabelecimento(estabelecimento);
			retorno.setUsuario(usuario);
			retorno.setValorTotal(BigDecimal.ZERO);
		} catch (Exception e) {
			LOOGER.error("OCORREU UM ERRO AO GERAR UMA COMPRA.",e);
			retorno = null;
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
			Compra compra = compraHelper.convertCompraVOToCompra(compraVO);
			if(compra != null){
				compra.setStatusCompra(getStatusCompraFinalizado());
				if(compraDAOImpl.update(compra)){
					retorno = compraHelper.convertToCompraVO(compra);
				}
			}
		}
		return retorno;
	}
}