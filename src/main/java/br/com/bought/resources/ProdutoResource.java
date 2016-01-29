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

import br.com.bought.business.ProdutoBusiness;
import br.com.bought.common.ProdutoVO;

@RestController
@RequestMapping("/produtos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	private ProdutoBusiness produtoBusiness;
	
	public ProdutoResource() {
		produtoBusiness = new ProdutoBusiness();
	}
	
    @GET
	@RequestMapping("/todos")
	public List<ProdutoVO> getTodosProdutos(){
		return produtoBusiness.listarTodos();
	}
	
	@RequestMapping(value = "/obterProdutoPorCodigoBarra/{codigoBarra}" , method = RequestMethod.GET)
	public ProdutoVO obterProdutoPorCodigoBarra(@PathVariable String codigoBarra){
		return produtoBusiness.obterPorCodigoBarra(codigoBarra);
	}
	
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public Long inserirProduto( @RequestBody ProdutoVO produtoVO){
		return produtoBusiness.salvar(produtoVO);
	}
	
	@RequestMapping(value =  "/deletar/{codigoBarra}", method = RequestMethod.GET)
	public Boolean deletarProduto(@PathVariable String codigoBarra){
		//return ProdutoDAO.removerProdutoPorCodigoBarra(codigoBarra);
		return null;
	}
}