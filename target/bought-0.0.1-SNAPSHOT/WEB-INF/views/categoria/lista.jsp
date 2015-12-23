<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<body>
		<a href="novoCategoria">Criar nova categoria.</a>
		<br />
		<br />
		<table>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>URL</th>

			</tr>
			<c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.descricaoCategoria}</td>
					<td>${categoria.urlFoto}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>