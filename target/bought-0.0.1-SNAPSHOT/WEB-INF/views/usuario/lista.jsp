<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<body>
		<a href="novoUsuario">Criar novo usuário.</a>
		<br />
		<br />
		<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Senha</th>
				<th>URL Foto</th>
				<th>Data Nascimento</th>
				<th>E-mail</th>
				<th>Usuário Ativo</th>
				<th>Data Cadastro</th>
				<th>Hashtags</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.password}</td>
					<td>${usuario.urlFoto}</td>
					<td>
						<fmt:formatDate value="${usuario.dataNascimento}"
							pattern="dd/MM/yyyy" />
					</td>
					<td>${usuario.email}</td>
					<c:if test="${usuario.isUsuarioAtivo eq true}">
						<td>Sim</td>
					</c:if>
					<c:if test="${usuario.isUsuarioAtivo eq false}">
						<td>
							<td>Não</td>
					  	</td>
					</c:if>
					<td>
						<fmt:formatDate value="${usuario.dataCadastro}"
							pattern="dd/MM/yyyy" />
					</td>
					<td>${usuario.hashtags}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>