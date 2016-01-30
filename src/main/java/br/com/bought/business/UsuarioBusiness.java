package br.com.bought.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.helper.UsuarioHelper;
import br.com.bought.model.Usuario;

public class UsuarioBusiness {
	
	private UsuarioDAOImpl usuarioDAOImpl;
	private UsuarioHelper usuarioHelper;
	
	public UsuarioBusiness(){
		usuarioHelper = new UsuarioHelper();
		usuarioDAOImpl = new UsuarioDAOImpl();
	}
	
	public Long salvar(UsuarioVO usuarioVO){
		Usuario  usuario = usuarioHelper.convertUsuarioVOToUsuario(usuarioVO);
		Long retorno = null;
		if(usuario != null){
			usuario.setDataCriacao(new Date());
			retorno = usuarioDAOImpl.salvar(usuario);
		}
		return retorno;
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

	public List<UsuarioVO> listarTodos() {
		List<UsuarioVO> retorno = null;
		List<Usuario> usuarios = usuarioDAOImpl.listarTodos();
		if(usuarios != null && usuarios.size() > 0){
			retorno = new ArrayList<UsuarioVO>();
			for (Usuario usuario : usuarios) {
				retorno.add(usuarioHelper.convertUsuarioToUsuarioVO(usuario));
			}
		}
		return retorno;
	}
}