package br.com.bought.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
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
