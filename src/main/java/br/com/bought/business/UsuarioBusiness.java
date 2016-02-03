package br.com.bought.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public UsuarioVO cadastrarUsuario(CadastroUsuarioVO cadastroUsuarioVO) {
		UsuarioVO retorno = null;
		if(cadastroUsuarioVO != null){
			Usuario usuario = new Usuario();
			usuario.setCpf(cadastroUsuarioVO.getCpf());
			usuario.setDataCriacao(new Date());
			usuario.setDataNascimento(cadastroUsuarioVO.getDataNascimento());
			usuario.setEmail(cadastroUsuarioVO.getEmail());
			usuario.setNome(cadastroUsuarioVO.getNome());
			usuario.setAtivo(Boolean.FALSE);
			usuario.setSenha(cadastroUsuarioVO.getSenha());
			
			try{
				Long id = usuarioDAOImpl.salvar(usuario);
				if(id != null){
					retorno = usuarioHelper.convertUsuarioToUsuarioVO(usuario);
					
					String chaveConfirmacao = EnviarEmailUtils.getChaveCriptografada(retorno);
					if(salvarChaveConfirmacaoCadastro(usuario, chaveConfirmacao)){
						enviarConfirmacaoEmail(retorno, chaveConfirmacao);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
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
}