package br.com.bought.resources;

import java.util.ArrayList;
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

import br.com.bought.model.Produto;

@RestController
@RequestMapping("/produtos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	private static List<Produto> produtos = new ArrayList<Produto>(); 
	
	static {
		produtos.add(new Produto(1, "Adoçante Molhado", new Double("3.49"), "789835741", "Alimento", "ASSUGRIN", "http://www.paodeacucar.com.br/img/uploads/1/403/474403x200x200.jpg"));
		produtos.add(new Produto(2, "Molho Frances de Tomate Provincial", new Double("11.25"), "789835742", "Alimento", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/463/339463x200x200.jpg"));
		produtos.add(new Produto(3, "Vaca Enlatada", new Double("7.35"), "789835743", "Alimento", "BORDON", "http://www.paodeacucar.com.br/img/uploads/1/538/504538x200x200.jpg"));
		produtos.add(new Produto(4, "Ervilha Zuada", new Double("4.19"), "789835744", "Enlatado", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/424/474424x200x200.jpg"));
		produtos.add(new Produto(5, "Meus Bago", new Double("3.12"), "789835745", "Alimento", "GALINHAX", "http://www.paodeacucar.com.br/img/uploads/1/354/473354x200x200.jpg"));
	}
	
    @GET
	@RequestMapping("/todos")
	public List<Produto> getTodosProdutos(){
		List<Produto> retorno = produtos; 
		return retorno;
	}
	
	@RequestMapping(value = "/obterproduto/{codigoBarra}" , method = RequestMethod.GET)
	public Produto obterProduto(@PathVariable String codigoBarra){
		Produto retorno = null;
		if (codigoBarra != null){
			for (Produto produtoVO : produtos) {
				if (codigoBarra.equals(produtoVO.getCodigoBarra())){
					retorno = produtoVO;
					break;
				}
			}
		}
		return retorno;		
	}
	
	@RequestMapping(value =  "/inserirproduto" , method = RequestMethod.POST)
	public Produto inserirProduto( @RequestBody Produto produto){
		try {
			produtos.add(produto);
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return produto;
	}
	
	@RequestMapping(value =  "/deletarproduto/{codigoBarra}", method = RequestMethod.GET)
	public Produto deletarProduto(@PathVariable String codigoBarra){
		Produto retorno = null;
		try {
			if (codigoBarra != null){
				for (Produto produtoVO : produtos) {
					if (codigoBarra.equals(produtoVO.getCodigoBarra())){
						retorno = produtoVO;
						produtos.remove(produtoVO);
						break;
					}
				}
			}
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return retorno;
	}
}


	

