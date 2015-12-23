<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<body>
		<a href="novoEvento">Criar novo evento.</a>
		<br />
		<br />
		<table>
			<tr>
				<th>Id</th>
				<th>Latitude</th>
				<th>Longitude</th>
				<th>Descricao Evento</th>
				<th>Assunto Evento</th>
				<th>Data Evento</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Tipo Logradouro</th>
				<th>Nome Logradouro</th>
				<th>Numero Logradouro</th>
				<th>CEP</th>
				<th>URL Foto</th>
			</tr>
			<c:forEach items="${eventos}" var="evento">
				<tr>
					<td>${evento.id}</td>
					<td>${evento.latitude}</td>
					<td>${evento.longitude}</td>
					<td>${evento.descricaEvento}</td>
					<td>${evento.descricaAssuntoEvento}</td>
					<td>
						<fmt:formatDate value="${evento.dataEvento}"
							pattern="dd/MM/yyyy HH:mm" />
					</td>
					<td>${evento.nomeCidade}</td>
					<td>${evento.siglaEstado}</td>
					<td>${evento.tipoLogradouro}</td>
					<td>${evento.nomeLogradouro}</td>
					<td>${evento.numeroLogradouro}</td>
					<td>${evento.numeroCep}</td>
					<td>${evento.urlFoto}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>