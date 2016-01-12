<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Adicionar Mercado</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Adicionar Mercado</h2>
		<form action="adicionaMercado" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="qrCode">QR Code:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="qrCode" id="qrCode"
						placeholder="Digite o QR Code">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">Nome:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nome" id="nome"
						placeholder="Digite o nome">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descricao">Descricao:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="descricao" id="descricao"
						placeholder="Digite a descricao">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeCidade">Cidade:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nomeCidade" id="nomeCidade"
						placeholder="Digite o nome da cidade">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="siglaEstado">Sigla Estado:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="siglaEstado" id="siglaEstado"
						placeholder="Digite a sigla do estado">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="tipoLogradouro">Tipo Logradouro:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="tipoLogradouro" id="tipoLogradouro"
						placeholder="Digite o tipo do logradouro">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeLogradouro">Logradouro:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nomeLogradouro" id="nomeLogradouro"
						placeholder="Digite o logradouro">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="numeroLogradouro">Numero:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="numeroLogradouro" id="numeroLogradouro"
						placeholder="Digite o numero">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="numeroCep">CEP:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="numeroCep" id="numeroCep"
						placeholder="Digite o CEP">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="urlFoto">URL Foto:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="urlFoto" id="urlFoto"
						placeholder="Digite a URL da foto">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Adicionar</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>