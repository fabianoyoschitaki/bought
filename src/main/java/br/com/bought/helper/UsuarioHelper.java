package br.com.bought.helper;

import org.springframework.beans.BeanUtils;

import br.com.bought.common.UsuarioVO;
import br.com.bought.model.Usuario;

public class UsuarioHelper {

//	private StatusCompra convertTOStatusCompra(StatusCompraVO statusCompraVO) {
//		StatusCompra retorno = null;
//		if(statusCompraDTO != null){
//			retorno = new StatusCompra();
//			BeanUtils.copyProperties(statusCompraDTO, retorno);
//		}
//		return retorno;
//	}

//	private Usuario convertToUsuario(UsuarioDTO usuarioDTO) {
//		Usuario retorno = null;
//		if(usuarioDTO != null){
//			retorno = new Usuario();
//			BeanUtils.copyProperties(usuarioDTO, retorno);
//		}
//		return retorno;
//	}




	public UsuarioVO convertUsuarioToUsuarioVO(Usuario usuario) {
		UsuarioVO retorno = null;
		if(usuario != null){
			retorno = new UsuarioVO();
			BeanUtils.copyProperties(usuario, retorno);
		}
		return retorno;
	}

//	public Usuario convertUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
//		Usuario retorno = null;
//		if(usuarioDTO != null){
//			retorno = new Usuario();
//			BeanUtils.copyProperties(usuarioDTO, retorno);
//		}
//		return retorno;
//	}
}
