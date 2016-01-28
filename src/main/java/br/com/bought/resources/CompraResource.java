package br.com.bought.resources;

import java.math.BigDecimal;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bought.business.CompraBusiness;
import br.com.bought.business.ProdutoBusiness;
import br.com.bought.common.CompraVO;
import br.com.bought.common.ItemCompraVO;
import br.com.bought.common.ProdutoVO;
import br.com.bought.common.UsuarioVO;

@RestController
@RequestMapping("/compra/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraResource {
	
	private CompraBusiness compraBusiness;
	private ProdutoBusiness produtoBusiness;

	public CompraResource() {
		produtoBusiness = new ProdutoBusiness();
		compraBusiness = new CompraBusiness();
	}
	
	@POST
	@RequestMapping("/novaCompra/{codigoEstabelecimento}")
	public CompraVO getNovaCompra(
		@PathVariable String codigoEstabelecimento, 
		@RequestBody UsuarioVO usuario){
		return compraBusiness.gerarCompra(codigoEstabelecimento, usuario);
	}
	
	@POST
	@RequestMapping("/obter/qrcode")
	public String getQRCodeCompra(
		@RequestParam String codigoPagamentoConfirmado, 
		@RequestParam String numeroCompra){
		String retorno = null;
		if (codigoPagamentoConfirmado != null && numeroCompra != null){
			//TODO verifica no paypal se pagou e recupera o número do carrinho dados do cliente
			retorno = UUID.randomUUID().toString();
		}
		return retorno;
	}
	
	@POST
	@RequestMapping("/obterItemCompraPorCodigoBarra/{codigoBarra}/{codigoEstabelecimento}")
	public ItemCompraVO obterItemCompraPorCodigoBarra(@PathVariable String codigoBarra, @PathVariable String codigoEstabelecimento){
		ItemCompraVO retorno = null;
		ProdutoVO produtoVO = produtoBusiness.obterPorCodigoBarra(codigoBarra);
		if(produtoVO != null){
			retorno = new ItemCompraVO();
			retorno.setProdutoVO(produtoVO);
			retorno.setQuantidade(0);
			//ACIONAR O FUTURO WS QUE VAI DESCOBRIR O VALOR DO PRODUTO NO ESTABELECIMENTO INFORMADO
			retorno.setValor(new BigDecimal("25.23"));
		}
		return retorno;
	}
	
	/**
	 * @param carrinho
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value =  "/finalizarCompra/{idCompra}", method = RequestMethod.POST)
	public CompraVO finalizarCompra(@PathVariable Long idCompra){
		return compraBusiness.finalizarCompra(idCompra);
	}
}