<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <body>
    <h3>Adicionar Usuario</h3>
  	<form:errors path="usuario.nome" cssStyle="color:red"/>
    <form action="adicionaUsuario" method="post">
      Nome: <input type="text" name="nome" cols="20"/><br/>
      E-mail: <input type="text" name="email" cols="30"/><br/>
      Data de nascimento: <input type="text" name="dataNascimento" pattern="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$" /><br/>
      Senha: <input type="text" name="password" cols="20"/><br/>
      URL Foto: <input type="text" name="urlFoto" cols="20"/><br/>
      Hashtags: <input type="text" name="hashtags" cols="30"/><br/>
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>