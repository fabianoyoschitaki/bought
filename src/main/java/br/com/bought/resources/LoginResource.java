package br.com.bought.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bought.business.LoginBusiness;
import br.com.bought.common.LoginVO;

@RestController
@RequestMapping("/login/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	private LoginBusiness loginBusiness;

	public LoginResource() {
		loginBusiness = new LoginBusiness();
	}
	
	@RequestMapping(value = "/autenticar/{email}/{senha}" , method = RequestMethod.GET)
	public LoginVO autenticar(@PathVariable String email, @PathVariable String senha){
		return loginBusiness.autenticar(email, senha);
	}
}