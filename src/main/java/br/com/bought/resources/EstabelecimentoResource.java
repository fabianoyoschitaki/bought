package br.com.bought.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bought.business.EstabelecimentoBusiness;
import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.MercadoVO;
import br.com.bought.dao.MercadoDAO;

@RestController
@RequestMapping("/estabelecimentos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstabelecimentoResource {
	
	private EstabelecimentoBusiness estabelecimentoBusiness;
	
	public EstabelecimentoResource(){
		estabelecimentoBusiness = new EstabelecimentoBusiness();
	}
	
    @GET
	@RequestMapping("/todos")
	public List<EstabelecimentoVO> getTodosEstabelecimentos(){
		return estabelecimentoBusiness.getTodosEstabelecimentos();
	}
	
	@RequestMapping(value = "/obter/id/{idEstabelecimento}", method = RequestMethod.GET)
	public EstabelecimentoVO obterEstabelecimentoPorId(@PathVariable Long idEstabelecimento){
		return estabelecimentoBusiness.obterEstabelecimentoPorId(idEstabelecimento);
	}
	
	@RequestMapping(value = "/obter/codigo/{codigoEstabelecimento}", method = RequestMethod.GET)
	public EstabelecimentoVO obterEstabelecimentoPorCodigo(@PathVariable String codigoEstabelecimento){
		return estabelecimentoBusiness.obterEstabelecimentoPorCodigoEstabelecimento(codigoEstabelecimento);
	}
	
	@RequestMapping(value = "/obter/qrcode/{qrCode}", method = RequestMethod.GET)
	public EstabelecimentoVO obterEstabelecimentoPorQRCode(@PathVariable String qrCode){
		return estabelecimentoBusiness.obterEstabelecimentoPorQRCode(qrCode);
	}
	
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public MercadoVO inserirMercado( @RequestBody MercadoVO mercado){
		return MercadoDAO.adicionarMercado(mercado);
	}
	
	@RequestMapping(value =  "/deletar/{id}", method = RequestMethod.GET)
	public MercadoVO deletarMercado(@PathVariable Integer id){
		return MercadoDAO.removerMercadoPorId(id);
	}
}