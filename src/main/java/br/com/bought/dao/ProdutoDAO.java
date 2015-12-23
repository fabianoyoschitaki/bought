package br.com.bought.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bought.model.Produto;

public class ProdutoDAO {

	private static List<Produto> produtos = new ArrayList<Produto>(); 
	private static int CONT = 1;
	static {
		produtos.add(new Produto(CONT++, "Adoçante Molhado", new Double("3.49"), "789835741", "Alimento", "ASSUGRIN", "http://www.paodeacucar.com.br/img/uploads/1/403/474403x200x200.jpg"));
		produtos.add(new Produto(CONT++, "Molho Frances de Tomate Provincial", new Double("11.25"), "789835742", "Alimento", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/463/339463x200x200.jpg"));
		produtos.add(new Produto(CONT++, "Vaca Enlatada", new Double("7.35"), "789835743", "Alimento", "BORDON", "http://www.paodeacucar.com.br/img/uploads/1/538/504538x200x200.jpg"));
		produtos.add(new Produto(CONT++, "Ervilha Zuada", new Double("4.19"), "789835744", "Enlatado", "CASINO", "http://www.paodeacucar.com.br/img/uploads/1/424/474424x200x200.jpg"));
		produtos.add(new Produto(CONT++, "Meus Bago", new Double("3.12"), "789835745", "Alimento", "GALINHAX", "http://www.paodeacucar.com.br/img/uploads/1/354/473354x200x200.jpg"));
	}
	
	/**
	 * Devolve a lista de todos os produtos
	 * 
	 * @return
	 */
	public static List<Produto> obterTodosProdutos(){
		return produtos;
	}
	
	/**
	 * Adiciona novo produto
	 * 
	 * @param produto
	 * @return
	 */
	public static Produto adicionarProduto(Produto produto){
		try {
			if (produto.getId() == null) produto.setId(CONT++);
			produtos.add(produto);
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return produto;
	}
	
	/**
	 * Retorna produto pelo código de barra
	 * 
	 * @param codigoBarra
	 * @return
	 */
	public static Produto obterProdutoPorCodigoBarra(String codigoBarra){
		Produto retorno = null;
		if (codigoBarra != null){
			for (Produto produtoVO : produtos) {
				if (codigoBarra.equals(produtoVO.getCodigoBarra())){
					retorno = produtoVO;
					break;
				}
			}
		}
		return retorno;	
	}

	/**
	 * Remove produto pelo codigo de barras
	 * 
	 * @param codigoBarra
	 * @return
	 */
	public static Produto removerProdutoPorCodigoBarra(String codigoBarra) {
		Produto retorno = null;
		try {
			if (codigoBarra != null){
				for (Produto produtoVO : produtos) {
					if (codigoBarra.equals(produtoVO.getCodigoBarra())){
						retorno = produtoVO;
						produtos.remove(produtoVO);
						break;
					}
				}
			}
		} catch (Exception e){
			System.out.println("Erro:" + e);
		}
		return retorno;
	}
}
