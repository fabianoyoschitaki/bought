<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <body>
    <h3>Adicionar Evento</h3>
    <form action="adicionaEvento" method="post">
      Latitude: <input type="text" name="latitude" cols="20"/><br/>
      Longitude: <input type="text" name="longitude" cols="20"/><br/>
      Data Evento: <input type="text" name="dataEvento" pattern="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$" /><br/>
      Descricao: <input type="text" name="descricaoEvento" cols="20"/><br/>
      DescricaoAssuntoEvento: <input type="text" name="descricaoAssuntoEvento" cols="20"/><br/>
      Cidade: <input type="text" name="nomeCidade" cols="20"/><br/>
      Estado: <input type="text" name="siglaEstado" cols="2"/><br/>
      Tipo Logradouro: <input type="text" name="tipoLogradouro" cols="20"/><br/>
      Logradouro: <input type="text" name="nomeLogradouro" cols="20"/><br/>
      Numero: <input type="text" name="numeroLogradouro" cols="20"/><br/>
      CEP: <input type="text" name="numeroCep" cols="8"/><br/>
      URL Foto: <input type="text" name="urlFoto" cols="20"/><br/>
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>