package br.com.bought.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bought.business.ProdutoBusiness;
import br.com.bought.model.Produto;

@Controller
public class ProdutoController {
	
	private ProdutoBusiness produtoBusiness;
	
	public ProdutoController() {
		produtoBusiness = new ProdutoBusiness();
	}
	
	@RequestMapping("novoProduto")
	public String form() {
		return "produto/formulario";
	}
	
	@RequestMapping("adicionaProduto")
	public String adiciona(@Valid Produto produto, BindingResult result) {
		//ProdutoDAO.adicionarProduto(produto);
		return "produto/adicionado";
	}

	@RequestMapping("listaProdutos")
	public String lista(Model model) {
		model.addAttribute("produtos", produtoBusiness.listarTodos());
		return "produto/lista";
	}
}
