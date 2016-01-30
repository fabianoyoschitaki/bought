package br.com.bought.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bought.business.ProdutoBusiness;
import br.com.bought.business.UsuarioBusiness;
import br.com.bought.common.ProdutoVO;
import br.com.bought.common.UsuarioVO;

@Controller
public class UsuarioController {
	
	private UsuarioBusiness usuarioBusiness;
	
	public UsuarioController() {
		usuarioBusiness = new UsuarioBusiness();
	}
	
	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid UsuarioVO usuarioVO, BindingResult result) {
		usuarioBusiness.salvar(usuarioVO);
		return "usuario/adicionado";
	}

	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		model.addAttribute("usuarios", usuarioBusiness.listarTodos());
		return "usuario/lista";
	}
}