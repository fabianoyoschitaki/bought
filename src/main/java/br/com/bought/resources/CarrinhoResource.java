package src.main.java.br.com.bought.resources;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {
	
	@GET
	@RequestMapping("/obter/novo")
	public String getNovoCarrinho(){
		return String.valueOf(new Date().getTime());
	}
}