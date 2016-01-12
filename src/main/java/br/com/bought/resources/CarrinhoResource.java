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
import org.springframework.web.bind.annotation.RestController;

import br.com.bought.common.CarrinhoVO;
import br.com.bought.common.MercadoVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.MercadoDAO;
import br.com.bought.dao.UsuarioDAO;

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
					retorno.setDataCarrinho(Calendar.getInstance());
					retorno.setNumeroCarrinho(UUID.randomUUID().toString());
				}
			}
		}
		return retorno;
	}
}
