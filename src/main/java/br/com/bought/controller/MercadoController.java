package br.com.bought.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bought.common.MercadoVO;
import br.com.bought.dao.MercadoDAO;

@Controller
public class MercadoController {
	
	@RequestMapping("novoMercado")
	public String form() {
		return "mercado/formulario";
	}
	
	@RequestMapping("adicionaMercado")
	public String adiciona(@Valid MercadoVO mercado, BindingResult result) {
		MercadoDAO.adicionarMercado(mercado);
		return "mercado/adicionado";
	}

	@RequestMapping("listaMercados")
	public String lista(Model model) {
		model.addAttribute("mercados", MercadoDAO.obterTodosMercados());
		return "mercado/lista";
	}
}
