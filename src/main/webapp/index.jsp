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
			
			var urlEstabelecimentos = window.location.href + "estabelecimentos/todos";
			$.getJSON(urlEstabelecimentos, function(data){
				if (data.length !== 0){
					$.each(data, function(i, estabelecimento) {
						$("<li/>", { "text": estabelecimento.nome + " - QR Code " + estabelecimento.qrCode})
							.append(" ").append($("<a/>", {
					  		 	"text" : window.location.href + "estabelecimentos/obter/qrcode/" + estabelecimento.qrCode,
							  	"href" : window.location.href + "estabelecimentos/obter/qrcode/" + estabelecimento.qrCode
						})).appendTo("#estabelecimentos");
					});
				} else {
					$("<li/>", {"text" : "Nenhum estabelecimento."}).appendTo("#estabelecimentos");
				}
			});
		</script>
	</head>
	<body>
		<h2>Bought 4.0</h2>
		<br />
		<h3>Historico</h3>
		<ul>
			<li>27/01/2016 - Fabiano <b>Alterando Mercado para Estabelecimento com Hibernate</b>				
			</li>
		</ul>
		<br />
		<h3>WS ConfirmacaoPagamentoGerarQRCODE</h3>
		<span>passar codigoPagamentoConfirmado e numeroCarrinho</span>
		<br />
		<a href="carrinho/obter/qrcode?codigoPagamentoConfirmado=123&numeroCarrinho=123">carrinho/obter/qrcode?codigoPagamentoConfirmado=123&numeroCarrinho=123</a>
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
		
		<h3>Estabelecimentos</h3>
		<a href="novoEstabelecimento">Criar Estabelecimento</a>
		<br />
		<a href="listaEstabelecimentos">Listar Estabelecimentos</a>
		<br />
		<a href="estabelecimentos/todos">Listar Estabelecimentos (REST)</a>
		<br />
		<br />
		<span>Obter Estabelecimento (REST)</span>
		<br />
		<ul id='estabelecimentos'></ul>
	</body>
</html>
