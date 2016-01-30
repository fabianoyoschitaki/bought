<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Adicionar Usuário</title>
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
		<h2>Adicionar Usuário</h2>
		<form action="adicionaUsuario" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">Nome:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nome" id="nome"
						placeholder="Digite o nome">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">E-mail:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="email" id="email"
						placeholder="Digite o e-mail">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="senha">Senha:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="senha" id="senha"
						placeholder="Digite a senha">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="confirmacaoSenha">Confirmação Senha:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="confirmacaoSenha"
						placeholder="Digite a senha novamente">
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