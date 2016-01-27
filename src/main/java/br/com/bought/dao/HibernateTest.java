package br.com.bought.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bought.business.CompraBusiness;
import br.com.bought.business.EstabelecimentoBusiness;
import br.com.bought.business.UsuarioBusiness;
import br.com.bought.common.EstabelecimentoVO;
import br.com.bought.common.ItemCompraVO;
import br.com.bought.common.ItemVO;
import br.com.bought.model.Usuario;

public class HibernateTest {
 
public static void main(String[] args) {
		EstabelecimentoVO estabelecimento = new EstabelecimentoVO();
		estabelecimento.setCodigoEstabelecimento("OIAWHEO1234");
		estabelecimento.setDescricao("Carrefour");
		estabelecimento.setNome("Carrefourt");
		estabelecimento.setNomeCidade("SÃO PAULO");
		
		EstabelecimentoBusiness estabelecimentoBusiness = new EstabelecimentoBusiness();
		Long id = estabelecimentoBusiness.salvar(estabelecimento);
    	
		CompraBusiness compraBusiness = new CompraBusiness();
		ItemVO itemVO = new ItemVO();
		itemVO.setCodigoBarra("98465135");
		itemVO.setNome("aoweijaewoiae");
		itemVO.setUrlImagem("www.google.com");
		
		ItemCompraVO itemCompraVO = new ItemCompraVO();
		itemCompraVO.setItemVO(itemVO);
		itemCompraVO.setQuantidade(4);
		itemCompraVO.setValor(new BigDecimal("35.4"));
		
		List<ItemCompraVO> itensCompraVO = new ArrayList<ItemCompraVO>();
		itensCompraVO.add(itemCompraVO);
		
//		EstabelecimentoVO estabelecimentoDTO = estabelecimentoBusiness.obterEstabelecimentoPorId(id);
//		
//		CarrinhoVO carrinho = new CarrinhoVO();
//		carrinho.setEstabelecimentoVO(estabelecimentoBusiness.convertToEstabelecimentoVO(estabelecimentoDTO));
//		carrinho.setItensCompraVO(itensCompraVO);
//		carrinho.setNumeroCarrinho("agwegawgawe1231s");
		
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		Usuario usuario = new Usuario();
		usuario.setEmail("hallan@hallan");
		usuario.setNome("Hallan");
		usuario.setDataCriacao(new Date());
		usuarioBusiness.salvar(usuario);
		
//		UsuarioVO usuarioDTO = usuarioBusiness.obterUsuarioPorEmail("hallan@hallan");
//		UsuarioVO usuarioVO = new UsuarioHelper().convertUsuarioDTOToUsuarioVO(usuarioDTO);
//	    CompraBusiness compraBusiness = new CompraBusiness();
//		CompraVO compraVO = compraBusiness.obterCompraPorId(Long.valueOf(1));
//		if(compraVO != null){
//			System.out.println(compraVO.getItensCompraVO().get(0).getQuantidade());
//		}
    }
}