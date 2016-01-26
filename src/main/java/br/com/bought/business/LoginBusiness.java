package br.com.bought.business;

import br.com.bought.common.LoginVO;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.helper.UsuarioHelper;
import br.com.bought.model.Usuario;

public class LoginBusiness {

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
		if(email != null && senha != null){
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(email);
			if(usuario != null){
				if(usuario.getSenha().equals(senha)){
					retorno.setMsg(MSG_LOGIN_SUCESSO);
					retorno.setStatus(COD_LOGIN_SUCESSO);
					retorno.setUsuario(helper.convertUsuarioToUsuarioVO(usuario));
				}else{
					retorno.setMsg(MSG_SENHA_INVALIDA);
					retorno.setStatus(COD_LOGIN_ERRO);
				}
			}else{
				retorno.setMsg(MSG_USUARIO_NAO_ENCONTRADO);
				retorno.setStatus(COD_LOGIN_ERRO);
			}
		}
		return retorno;
	}
}