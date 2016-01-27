package br.com.bought.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bought.business.EstabelecimentoBusiness;
import br.com.bought.common.EstabelecimentoVO;

@Controller
public class EstabelecimentoController {
	
	@RequestMapping("novoEstabelecimento")
	public String form() {
		return "estabelecimento/formulario";
	}
	
	@RequestMapping("adicionaEstabelecimento")
	public String adiciona(@Valid EstabelecimentoVO estabelecimentoVO, BindingResult result) {
		EstabelecimentoBusiness estabelecimentoBusiness = new EstabelecimentoBusiness();
		estabelecimentoBusiness.salvar(estabelecimentoVO);
		return "estabelecimento/adicionado";
	}

	@RequestMapping("listaEstabelecimentos")
	public String lista(Model model) {
		EstabelecimentoBusiness estabelecimentoBusiness = new EstabelecimentoBusiness();
		model.addAttribute("estabelecimentos", estabelecimentoBusiness.getTodosEstabelecimentos());
		return "estabelecimento/lista";
	}
}
