package br.com.bought.business;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.model.Usuario;

public class UsuarioBusiness {
	
	private UsuarioDAOImpl usuarioDAOImpl;
	
	public UsuarioBusiness(){
		usuarioDAOImpl = new UsuarioDAOImpl();
	}
	
	public Long salvar(Usuario usuario){
		return usuarioDAOImpl.salvar(usuario);
	}
	
	public UsuarioVO obterUsuarioPorEmail(final String email){
		UsuarioVO usuarioVO = null;
		try{
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(email);
			if(usuario != null){
				usuarioVO = new UsuarioVO();
				BeanUtils.copyProperties(usuario, usuarioVO);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return usuarioVO;
	}
	
	public boolean isUsuarioValido(UsuarioVO usuarioVO) {
		Boolean retorno = Boolean.FALSE;
		if(usuarioVO != null && usuarioVO.getEmail() != null){
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(usuarioVO.getEmail());
			if(usuario != null && 
					usuario.getEmail() != null && 
					usuario.getEmail().equals(usuarioVO.getEmail())){
				retorno = Boolean.TRUE;
			}
		}
		return retorno;
	}
}