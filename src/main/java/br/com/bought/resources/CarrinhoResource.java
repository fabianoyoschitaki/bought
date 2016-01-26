package br.com.bought.resources;

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

import br.com.bought.business.CarrinhoBusiness;
import br.com.bought.business.CompraBusiness;
import br.com.bought.common.CarrinhoVO;
import br.com.bought.common.CompraVO;
import br.com.bought.common.UsuarioVO;

@RestController
@RequestMapping("/carrinho/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {
	
	private CompraBusiness compraBusiness;
	private CarrinhoBusiness carrinhoBusiness;

	public CarrinhoResource() {
		compraBusiness = new CompraBusiness();
		carrinhoBusiness = new CarrinhoBusiness();
	}
	
	@POST
	@RequestMapping("/obter/novo/{codigoEstabelecimento}")
	public CarrinhoVO getNovoCarrinho(
		@PathVariable String codigoEstabelecimento, 
		@RequestBody UsuarioVO usuario){
		return carrinhoBusiness.getNovoCarrinho(codigoEstabelecimento, usuario);
	}
	
	@POST
	@RequestMapping("/obter/qrcode")
	public String getQRCodeCompra(
		@RequestParam String codigoPagamentoConfirmado, 
		@RequestBody CarrinhoVO carrinhoVO){
		String retorno = null;
		if (codigoPagamentoConfirmado != null && carrinhoVO != null){
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
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public CompraVO finalizarCarrinho(@RequestBody CarrinhoVO carrinho, 
			@RequestBody UsuarioVO usuario){
		return compraBusiness.gerarCompra(carrinho, usuario);
	}
}