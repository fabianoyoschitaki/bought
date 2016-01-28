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
	
	@RequestMapping(value =  "/inserirEstabelecimento", method = RequestMethod.POST)
	public Long inserirEstabelecimento( @RequestBody EstabelecimentoVO estabelecimentoVO){
		return estabelecimentoBusiness.inserirEstabelecimento(estabelecimentoVO);
	}
}