package br.com.bought.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import br.com.bought.common.CadastroUsuarioVO;
import br.com.bought.common.RetornoAtivarUsuarioVO;
import br.com.bought.common.UsuarioVO;
import br.com.bought.dao.AtivacaoCadastroUsuarioDAOImpl;
import br.com.bought.dao.UsuarioDAOImpl;
import br.com.bought.helper.UsuarioHelper;
import br.com.bought.model.AtivacaoCadastroUsuario;
import br.com.bought.model.Usuario;
import br.com.bought.utils.EnviarEmailUtils;

public class UsuarioBusiness {
	
	private static final Logger LOOGER = 
		      Logger.getLogger(UsuarioBusiness.class);
	
	private static final String MSG_NAO_FOI_POSSIVEL_ATIVAR_USUARIO = "Desculpe, não foi possível ativar o usuário.";
	private static final String MSG_USUARIO_NAO_ENCONTRADO = "O usuário não foi encontrado.";
	private static final String MSG_CHAVE_CONFIRMACAO_INVALIDA = "A chave de confirmação é inválida.";
	private UsuarioDAOImpl usuarioDAOImpl;
	private AtivacaoCadastroUsuarioDAOImpl ativacaoCadastroUsuarioDAOImpl;
	private UsuarioHelper usuarioHelper;
	
	public UsuarioBusiness(){
		ativacaoCadastroUsuarioDAOImpl = new AtivacaoCadastroUsuarioDAOImpl();
		usuarioHelper = new UsuarioHelper();
		usuarioDAOImpl = new UsuarioDAOImpl();
	}
	
	public Long salvar(UsuarioVO usuarioVO){
		LOOGER.info("UsuarioBusiness.salvar - INICIO");
		Usuario  usuario = usuarioHelper.convertUsuarioVOToUsuario(usuarioVO);
		Long retorno = null;
		if(usuario != null){
			usuario.setDataCriacao(new Date());
			retorno = usuarioDAOImpl.salvar(usuario);
			if(retorno != null)
				LOOGER.info("USUÁRIO SALVO COM SUCESSO: " + retorno);
		}
		LOOGER.info("UsuarioBusiness.salvar - FIM");
		return retorno;
	}
	
	public UsuarioVO obterUsuarioPorEmail(final String email){
		LOOGER.info("UsuarioBusiness.obterUsuarioPorEmail - INICIO");
		UsuarioVO usuarioVO = null;
		try{
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorEmail(email);
			if(usuario != null){
				usuarioVO = new UsuarioVO();
				BeanUtils.copyProperties(usuario, usuarioVO);
			}
		}catch (Exception e){
			LOOGER.error("OCORREU UM ERRO AO OBTER O USUÁRIO POR E-MAIL", e);
		}
		LOOGER.info("UsuarioBusiness.obterUsuarioPorEmail - INICIO");
		return usuarioVO;
	}

	

	public List<UsuarioVO> listarTodos() {
		LOOGER.info("UsuarioBusiness.listarTodos - INICIO");
		List<UsuarioVO> retorno = null;
		List<Usuario> usuarios = usuarioDAOImpl.listarTodos();
		if(usuarios != null && usuarios.size() > 0){
			LOOGER.info("USUÁRIO ENCONTRADOS: " + usuarios.size());
			retorno = new ArrayList<UsuarioVO>();
			for (Usuario usuario : usuarios) {
				retorno.add(usuarioHelper.convertUsuarioToUsuarioVO(usuario));
			}
		}
		LOOGER.info("UsuarioBusiness.listarTodos - FIM");
		return retorno;
	}

	public UsuarioVO cadastrarUsuario(CadastroUsuarioVO cadastroUsuarioVO) {
		LOOGER.info("UsuarioBusiness.cadastrarUsuario - INICIO");
		UsuarioVO retorno = null;
		if(cadastroUsuarioVO != null){
			Usuario usuario = new Usuario();
			usuario.setCpf(cadastroUsuarioVO.getCpf());
			usuario.setDataCriacao(new Date());
			usuario.setDataNascimento(cadastroUsuarioVO.getDataNascimento());
			usuario.setEmail(cadastroUsuarioVO.getEmail());
			usuario.setNome(cadastroUsuarioVO.getNome());
			
			if(cadastroUsuarioVO.getIdFacebook() != null && cadastroUsuarioVO.getIdFacebook() != ""){
				usuario.setAtivo(Boolean.TRUE);
			}else{
				usuario.setAtivo(Boolean.FALSE);
			}
			usuario.setSenha(cadastroUsuarioVO.getSenha());
			usuario.setIdFacebook(cadastroUsuarioVO.getIdFacebook());
			
			try{
				Long id = usuarioDAOImpl.salvar(usuario);
				if(id != null){
					LOOGER.info("USUÁRIO CADASTRADO: " + id);
					retorno = usuarioHelper.convertUsuarioToUsuarioVO(usuario);
					
					String chaveConfirmacao = EnviarEmailUtils.getChaveCriptografada(retorno);
					LOOGER.info("CHAVE DE CONFIRMAÇÃO GERADA: " + chaveConfirmacao);
					if(salvarChaveConfirmacaoCadastro(usuario, chaveConfirmacao)){
						if(enviarConfirmacaoEmail(retorno, chaveConfirmacao)){
							LOOGER.info("CHAVE DE CONFIRMAÇÃO ENVIADA POR E-MAIL COM SUCESSO.");
						}
					}
				}
			}catch(Exception e){
				LOOGER.error("OCORREU UM ERRO AO CADASTRAR USUÁRIO.", e);
			}
		}
		LOOGER.info("UsuarioBusiness.cadastrarUsuario - FIM");
		return retorno;
	}
	
	
	private boolean salvarChaveConfirmacaoCadastro(Usuario usuario,
			String chaveConfirmacao) {
		Boolean retorno = Boolean.FALSE;
		AtivacaoCadastroUsuario ativacaoCadastroUsuario = new AtivacaoCadastroUsuario();
		ativacaoCadastroUsuario.setUsuario(usuario);
		ativacaoCadastroUsuario.setChaveConfirmacao(chaveConfirmacao);
		Long id = ativacaoCadastroUsuarioDAOImpl.salvar(ativacaoCadastroUsuario);
		if(id != null){
			LOOGER.info("CHAVE DE CONFIRMAÇÃO SALVA COM SUCESSO: " + chaveConfirmacao);
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	private Boolean enviarConfirmacaoEmail(UsuarioVO usuarioVO, String chaveConfirmacao){
		return EnviarEmailUtils.enviarEmail(EnviarEmailUtils.getCorpoEmail(usuarioVO, chaveConfirmacao), usuarioVO.getEmail());
	}

	public RetornoAtivarUsuarioVO ativarUsuario(String key) {
		RetornoAtivarUsuarioVO retorno = new RetornoAtivarUsuarioVO();
		AtivacaoCadastroUsuario ativacaoCadastroUsuario = ativacaoCadastroUsuarioDAOImpl.obterAtivacaoCadastroUsuarioPorChave(key);
		if(ativacaoCadastroUsuario != null){
			Usuario usuario = ativacaoCadastroUsuario.getUsuario();
			if(usuario != null){
				usuario.setAtivo(Boolean.TRUE);
				if(usuarioDAOImpl.update(usuario)){
					retorno.setMensagem(getMensagemSucesso(usuarioHelper.convertUsuarioToUsuarioVO(usuario)));
				}else{
					retorno.setMensagem(MSG_NAO_FOI_POSSIVEL_ATIVAR_USUARIO);
				}
			}else{
				retorno.setMensagem(MSG_USUARIO_NAO_ENCONTRADO);
			}
		}else{
			retorno.setMensagem(MSG_CHAVE_CONFIRMACAO_INVALIDA);
		}
		return retorno;
	}

	private String getMensagemSucesso(UsuarioVO usuarioVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("Pronto " + usuarioVO.getNome() + "!\n Seu usuário foi ativado com sucesso.");
		return sb.toString();
	}

	public UsuarioVO obterUsuarioPorCpf(final String cpf){
		LOOGER.info("UsuarioBusiness.obterUsuarioPorCpf - INICIO");
		UsuarioVO usuarioVO = null;
		try{
			Usuario usuario = usuarioDAOImpl.obterUsuarioPorCpf(cpf);
			if(usuario != null){
				usuarioVO = new UsuarioVO();
				BeanUtils.copyProperties(usuario, usuarioVO);
			}
		}catch (Exception e){
			LOOGER.error("OCORREU UM ERRO AO OBTER O USUÁRIO POR CPF", e);
		}
		LOOGER.info("UsuarioBusiness.obterUsuarioPorCpf - INICIO");
		return usuarioVO;
	}
}