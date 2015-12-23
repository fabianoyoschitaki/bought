<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <body>
    <h3>Adicionar Categoria</h3>
<%--   	<form:errors path="usuario.nome" cssStyle="color:red"/> --%>
    <form action="adicionaCategoria" method="post">
      Descrição: <input type="text" name="descricaoCategoria" cols="20"/><br/>
      URL Foto: <input type="text" name="urlFoto" cols="20"/><br/>
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>