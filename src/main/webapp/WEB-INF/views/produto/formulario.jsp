<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Adicionar Produto</title>
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
		<h2>Adicionar Produto</h2>
		<form action="adicionaProduto" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">Nome:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nome" id="nome"
						placeholder="Digite o nome">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="preco">Preco:</label>
				<div class="col-sm-10">
					<input type="number" step="0.01" min="0" class="form-control" id="preco" name="preco"
						placeholder="Digite o preco">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codigoBarra">Codigo Barra:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="codigoBarra" id="codigoBarra"
						placeholder="Digite o codigo de barra">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="categoria">Categoria:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="categoria" id="categoria"
						placeholder="Digite a categoria">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="marca">Marca:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="marca"
						placeholder="Digite a marca">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="urlImagem">URL Imagem:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="urlImagem" id="urlImagem"
						placeholder="Digite a URL da imagem">
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