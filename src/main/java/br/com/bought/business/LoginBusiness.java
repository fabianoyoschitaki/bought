package br.com.bought.business;

import org.apache.log4j.Logger;

import br.com.bought.common.LoginVO;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.helper.UsuarioHelper;
import br.com.bought.model.Usuario;

public class LoginBusiness {

	private static final Logger LOOGER = 
		      Logger.getLogger(LoginBusiness.class);
	
	private static final Integer COD_LOGIN_SUCESSO = 0;
	private static final Integer COD_LOGIN_ERRO = 1;
	private static final String MSG_LOGIN_SUCESSO = "Login efetuado com sucesso.";
	private static final String MSG_USUARIO_NAO_ENCONTRADO = "Usuário não encontrado.";
	private static final String MSG_SENHA_INVALIDA = "Senha inválida.";
	
	
	private UsuarioHelper helper;
	private UsuarioDAOImpl usuarioDAOImpl;
	
	public LoginBusiness(){
		usuarioDAOImpl = new UsuarioDAOImpl();
		helper = new UsuarioHelper();
	}

	public LoginVO autenticar(String email, String senha){
		LoginVO retorno = new LoginVO();
		LOOGER.info("LoginBusiness.autenticar - INICIO");
		if(email != null && senha != null){
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(email);
			if(usuario != null){
				LOOGER.info("USUARIO ENCONTRADO: " + usuario.getId());
				if(usuario.getAtivo()){
					if(usuario.getSenha().equals(senha)){
						retorno.setMsg(MSG_LOGIN_SUCESSO);
						retorno.setStatus(COD_LOGIN_SUCESSO);
						retorno.setUsuario(helper.convertUsuarioToUsuarioVO(usuario));
						LOOGER.info("USUARIO AUTENTICADO COM SUCESSO: " + usuario.getId());
					}else{
						LOOGER.info("SENHA INVÁLIDA: " + senha);
						retorno.setMsg(MSG_SENHA_INVALIDA);
						retorno.setStatus(COD_LOGIN_ERRO);
					}
				}else{
					LOOGER.info("USUARIO DESATIVADO: " + usuario.getId());
					retorno.setMsg(MSG_USUARIO_NAO_ENCONTRADO);
					retorno.setStatus(COD_LOGIN_ERRO);
				}
			}else{
				LOOGER.info("USUARIO NÃO ENCONTRADO: " + email);
				retorno.setMsg(MSG_USUARIO_NAO_ENCONTRADO);
				retorno.setStatus(COD_LOGIN_ERRO);
			}
		}
		LOOGER.info("LoginBusiness.autenticar - FIM");
		return retorno;
	}
}