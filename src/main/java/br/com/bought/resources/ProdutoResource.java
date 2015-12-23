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

import br.com.bought.dao.ProdutoDAO;
import br.com.bought.model.Produto;

@RestController
@RequestMapping("/produtos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
    @GET
	@RequestMapping("/todos")
	public List<Produto> getTodosProdutos(){
		return ProdutoDAO.obterTodosProdutos();
	}
	
	@RequestMapping(value = "/obter/{codigoBarra}" , method = RequestMethod.GET)
	public Produto obterProduto(@PathVariable String codigoBarra){
		return ProdutoDAO.obterProdutoPorCodigoBarra(codigoBarra);
	}
	
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public Produto inserirProduto( @RequestBody Produto produto){
		return ProdutoDAO.adicionarProduto(produto);
	}
	
	@RequestMapping(value =  "/deletar/{codigoBarra}", method = RequestMethod.GET)
	public Produto deletarProduto(@PathVariable String codigoBarra){
		return ProdutoDAO.removerProdutoPorCodigoBarra(codigoBarra);
	}
}


	

