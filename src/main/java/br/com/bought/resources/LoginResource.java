package br.com.bought.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bought.common.LoginVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.UsuarioDAO;

@RestController
@RequestMapping("/login/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	private static final Integer COD_LOGIN_SUCESSO = 0;
	private static final Integer COD_LOGIN_ERRO = 1;
	private static final String MSG_LOGIN_SUCESSO = "Login efetuado com sucesso.";
	private static final String MSG_USUARIO_NAO_ENCONTRADO = "Usuário não encontrado.";
	private static final String MSG_SENHA_INVALIDA = "Senha inválida.";
	
	
	@RequestMapping(value = "/autenticar/{email}/{senha}" , method = RequestMethod.GET)
	public LoginVO autenticar(@PathVariable String email, @PathVariable String senha){
		LoginVO retorno = new LoginVO();
		UsuarioVO usuario = UsuarioDAO.obterUsuarioByEmail(email);
		if(usuario != null){
			if(usuario.getSenha().equals(senha)){
				retorno.setMsg(MSG_LOGIN_SUCESSO);
				retorno.setStatus(COD_LOGIN_SUCESSO);
				retorno.setUsuario(usuario);
			}else{
				retorno.setMsg(MSG_SENHA_INVALIDA);
				retorno.setStatus(COD_LOGIN_ERRO);
			}
		}else{
			retorno.setMsg(MSG_USUARIO_NAO_ENCONTRADO);
			retorno.setStatus(COD_LOGIN_ERRO);
		}
		return retorno;
	}
	
}


	

