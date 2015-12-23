<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script>
			var urlProdutos = window.location.href + "produtos/todos";
			$.getJSON(urlProdutos, function(data){
				if (data.length !== 0){
					$.each(data, function(i, produto) {
						$("<li/>", { "text": produto.nome + " - R$ " + produto.preco})
							.append(" ").append($("<a/>", {
					  		 	"text" : window.location.href + "produtos/obter/" + produto.codigoBarra,
							  	"href" : window.location.href + "produtos/obter/" + produto.codigoBarra
						})).appendTo("#produtos");
					});
				} else {
					$("<li/>", {"text" : "Nenhum produto."}).appendTo("#produtos");
				}
			});
		</script>
	</head>
	<body>
		<h2>Bought 1.0</h2>
		<br />
		<h3>Produtos</h3>
		<a href="novoProduto">Criar Produto</a>
		<br />
		<a href="listaProdutos">Listar Produtos</a>
		<br />
		<a href="produtos/todos">Listar Produtos (REST)</a>
		<br />
		<br />
		<span>Obter Produto (REST)</span>
		<br />
		<ul id='produtos'></ul>
	</body>
</html>
