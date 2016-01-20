package br.com.bought.resources;

import java.util.Calendar;
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

import br.com.bought.common.CarrinhoVO;
import br.com.bought.common.CompraVO;
import br.com.bought.common.MercadoVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.MercadoDAO;
import br.com.bought.dao.UsuarioDAO;
import br.com.bought.enums.StatusCarrinhoENUM;
import br.com.bought.enums.StatusCompraENUM;
import br.com.bought.utils.BoughtUtils;

@RestController
@RequestMapping("/carrinho/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {
	
	@POST
	@RequestMapping("/obter/novo/{codigoMercado}")
	public CarrinhoVO getNovoCarrinho(
		@PathVariable String codigoMercado, 
		@RequestBody UsuarioVO usuario){
		CarrinhoVO retorno = new CarrinhoVO();
		if (usuario != null){
			UsuarioVO u = UsuarioDAO.obterUsuarioByEmail(usuario.getEmail());
			if (u != null){
				MercadoVO mercado = MercadoDAO.obterMercadoPorQRCode(codigoMercado);
				if (mercado != null){
					retorno.setMercado(mercado);
					retorno.setStatusCarrinho(StatusCarrinhoENUM.EM_COMPRAS);
					retorno.setDataCarrinho(Calendar.getInstance());
					retorno.setNumeroCarrinho(UUID.randomUUID().toString());
				}
			}
		}
		return retorno;
	}
	
	@POST
	@RequestMapping("/obter/qrcode")
	public String getQRCodeCompra(
		@RequestParam String codigoPagamentoConfirmado, 
		@RequestParam String numeroCarrinho){
		String retorno = null;
		if (codigoPagamentoConfirmado != null && numeroCarrinho != null){
			//TODO verifica no paypal se pagou e recupera o número do carrinho dados do cliente
			retorno = UUID.randomUUID().toString();
		}
		return retorno;
	}
	
	/**
	 * Este método é acionado para finalizar o carrinho de compras.
	 * Tem como tarefa gerar uma compra na base de dados e retornar o objeto CompraVO 
	 * para o apk.
	 * @param carrinho
	 * @param usuario
	 * @return
	 */
	//TODO ATUALIZAR INFORMAÇÕES DO CARRINHO NA BASE.
	//TODO GERAR COMPRA NA BASE.
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public CompraVO finalizarCarrinho(@RequestBody CarrinhoVO carrinho, 
			@RequestBody UsuarioVO usuario){
		CompraVO compra = null;
		if(carrinho != null && usuario != null){
			compra = new CompraVO();
			carrinho.setStatusCarrinho(StatusCarrinhoENUM.FINALIZADO);
			compra.setCarrinho(carrinho);
			compra.setDataGeracaoCompra(Calendar.getInstance());
			compra.setStatusCompra(StatusCompraENUM.AGUARDANDO_PAGAMENTO);
			compra.setValor(BoughtUtils.getValorCompraFromCarrinho(carrinho));
		}
		return compra;
	}
}
