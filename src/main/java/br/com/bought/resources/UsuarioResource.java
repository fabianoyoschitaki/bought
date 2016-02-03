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

import br.com.bought.business.UsuarioBusiness;
import br.com.bought.common.CadastroUsuarioVO;
import br.com.bought.common.UsuarioVO;

@RestController
@RequestMapping("/usuarios/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	private UsuarioBusiness usuarioBusiness;
	
	public UsuarioResource() {
		usuarioBusiness = new UsuarioBusiness();
	}
	
    @GET
	@RequestMapping("/todos")
	public List<UsuarioVO> getTodosUsuarios(){
		return usuarioBusiness.listarTodos();
	}
	
	@RequestMapping(value = "/obterUsuarioPorEmail/{email}" , method = RequestMethod.GET)
	public UsuarioVO obterUsuarioPorEmail(@PathVariable String email){
		return usuarioBusiness.obterUsuarioPorEmail(email);
	}
	
	@RequestMapping(value =  "/inserir", method = RequestMethod.POST)
	public Long inserirUsuario( @RequestBody UsuarioVO usuarioVO){
		return usuarioBusiness.salvar(usuarioVO);
	}
	
	@RequestMapping(value =  "/cadastrarUsuario", method = RequestMethod.POST)
	public UsuarioVO cadastrarUsuario(@RequestBody CadastroUsuarioVO cadastroUsuarioVO){
		return usuarioBusiness.cadastrarUsuario(cadastroUsuarioVO);
	}
}