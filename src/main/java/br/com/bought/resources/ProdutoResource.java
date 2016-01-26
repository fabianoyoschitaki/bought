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

import br.com.bought.model.Item;

@RestController
@RequestMapping("/produtos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
    @GET
	@RequestMapping("/todos")
	public List<Item> getTodosProdutos(){
		//return ProdutoDAO.obterTodosProdutos();
    	return null;
	}
	
	@RequestMapping(value = "/obter/{codigoBarra}" , method = RequestMethod.GET)
	public Item obterProduto(@PathVariable String codigoBarra){
		//return ProdutoDAO.obterProdutoPorCodigoBarra(codigoBarra);
		return null;
	}
	
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public Item inserirProduto( @RequestBody Item produto){
		//return ProdutoDAO.adicionarProduto(produto);
		return null;
	}
	
	@RequestMapping(value =  "/deletar/{codigoBarra}", method = RequestMethod.GET)
	public Item deletarProduto(@PathVariable String codigoBarra){
		//return ProdutoDAO.removerProdutoPorCodigoBarra(codigoBarra);
		return null;
	}
}