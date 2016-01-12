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
			
			var urlMercados = window.location.href + "mercados/todos";
			$.getJSON(urlMercados, function(data){
				if (data.length !== 0){
					$.each(data, function(i, mercado) {
						$("<li/>", { "text": mercado.nome + " - QR " + mercado.qrCode})
							.append(" ").append($("<a/>", {
					  		 	"text" : window.location.href + "mercados/obter/" + mercado.qrCode,
							  	"href" : window.location.href + "mercados/obter/" + mercado.qrCode
						})).appendTo("#mercados");
					});
				} else {
					$("<li/>", {"text" : "Nenhum mercado."}).appendTo("#mercados");
				}
			});
		</script>
	</head>
	<body>
		<h2>Bought 2.0</h2>
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
		<br />
		
		<h3>Mercados</h3>
		<a href="novoMercado">Criar Mercado</a>
		<br />
		<a href="listaMercados">Listar Mercados</a>
		<br />
		<a href="mercados/todos">Listar Mercados (REST)</a>
		<br />
		<br />
		<span>Obter Mercado (REST)</span>
		<br />
		<ul id='mercados'></ul>
	</body>
</html>
