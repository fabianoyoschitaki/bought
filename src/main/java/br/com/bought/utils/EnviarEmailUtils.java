package br.com.bought.utils;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.SimpleAliasRegistry;

import br.com.bought.common.UsuarioVO;

public class EnviarEmailUtils {

	private static final String DESCRICAO_ASSUNTO_EMAIL = "Confirmação de cadastro - Ibought";
	private static final String SERVIDOR = "http://54.200.195.122/";
	private static final String CONTEXTO_APP = "bought-web/";
	private static final String CONFIRMACAO_PAGE = "confirmacaoCadastro.jsp?key=";

	private static Properties getDefaultProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		return props;
	}

	private static Session getSession() {
		Session session = Session.getDefaultInstance(getDefaultProperties(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"contato.lohra@gmail.com", "jmartins25");
					}
				});
		return session;
	}

	public static Boolean enviarEmail(String corpo, String destinatario) {
		Boolean retorno = Boolean.FALSE;
		try {

			Session session = getSession();
			Transport transport = session.getTransport();
			MimeMessage message = new MimeMessage(session);
			message.setSubject(DESCRICAO_ASSUNTO_EMAIL);
			message.setFrom(new InternetAddress("contato.lohra@gmail.com"));
			message.setContent(corpo, "text/html");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					destinatario));
			transport.connect();
			transport.sendMessage(message,
					message.getRecipients(Message.RecipientType.TO));
			transport.close();
			retorno = Boolean.TRUE;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}

	public static String getCorpoEmail(UsuarioVO usuarioVO,
			String chaveConfirmacaoEmail) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<h3>Olá " + usuarioVO.getNome()
				+ ",você se cadastrou no Ibought.</h3>");
		sb.append("<a href="
				+ getLinkConfirmacao(usuarioVO, chaveConfirmacaoEmail)
				+ ">Clique aqui para validar seu cadastro</a>");
		sb.append("</html>");
		sb.append("</body>");
		return sb.toString();
	}

	private static String getLinkConfirmacao(UsuarioVO usuarioVO,
			String chaveConfirmacaoEmail) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVIDOR);
		sb.append(CONTEXTO_APP);
		sb.append(CONFIRMACAO_PAGE);
		sb.append(chaveConfirmacaoEmail);
		return sb.toString();
	}

	public static String getChaveCriptografada(UsuarioVO usuarioVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("id=");
		sb.append(usuarioVO.getId());
		sb.append("-");
		sb.append(new SimpleDateFormat("dd/MM/yyyy").format(usuarioVO
				.getDataCriacao()));
		sb.append("-");
		sb.append(new SimpleDateFormat("HH:mm:ss").format(usuarioVO
				.getDataCriacao()));
		return Criptografia.criptografar(sb.toString());
	}
}