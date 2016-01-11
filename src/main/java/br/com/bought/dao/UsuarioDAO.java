package br.com.bought.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bought.common.UsuarioVO;

public class UsuarioDAO {


	private static List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>(); 
	private static int CONT = 1;
	static {
		usuarios.add(new UsuarioVO(CONT++, "Admin", "admin@bought.com.br", "123456"));
	}
	
	
	public static UsuarioVO obterUsuarioByEmail(String email){
		UsuarioVO retorno = null;
		for (UsuarioVO usuarioVO : usuarios) {
			if(usuarioVO.getEmail().equals(email)){
				retorno = usuarioVO;
			}
		}
		return retorno;
	}
}
