<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>Lista de Mercados</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<body>
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	     <div class="modal-header">
	         <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	         <h3 id="myModalLabel">Remover</h3>
	     </div>
	     <div class="modal-body">
	         <p></p>
	     </div>
	     <div class="modal-footer">
	         <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
	         <button data-dismiss="modal" class="btn red" id="btnYes">Confirmar</button>
	     </div>
  	</div>
	<div class="container">
		<h2>Lista de Estabelecimentos</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Foto</th>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Descricao</th>
					<th>Cidade</th>
					<th>Estado</th>
					<th>Tipo Logradouro</th>
					<th>Logradouro</th>
					<th>Numero</th>
					<th>CEP</th>
				</tr>
			</thead>
			<tbody>
      			<c:forEach items="${estabelecimentos}" var="estabelecimento">
					<tr>
						<td><img src="${estabelecimento.urlLogo}" alt="" border='3' height='50' width='50' /></td>
						<td>${estabelecimento.codigoEstabelecimento}</td>
						<td>${estabelecimento.nome}</td>
						<td>${estabelecimento.descricao}</td>
						<td>${estabelecimento.nomeCidade}</td>
						<td>${estabelecimento.siglaEstado}</td>
						<td>${estabelecimento.tipoLogradouro}</td>
						<td>${estabelecimento.nomeLogradouro}</td>
						<td>${estabelecimento.numeroLogradouro}</td>
						<td>${estabelecimento.numeroCep}</td>
						<td><a href="#" class="btn btn-warning mini blue-stripe">Editar</a></td>
                        <td><a href="#" class="confirm-delete btn btn-danger" role="button">Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-md-4 text-center"> 
			<a href="novoEstabelecimento" class="btn btn-success" role="button">Novo Estabelecimento</a>
		</div>
	</div>
	
	<!-- script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script-->
		
	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<script type='text/javascript'
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	
	<script type='text/javascript'>
        
        $(document).ready(function() {
			$('#myModal').on('show', function() {
			    var tit = $('.confirm-delete').data('title');
			    $('#myModal .modal-body p').html("Deseja remover estabelecimento " + '<b>' + tit +'</b>' + ' ?');
			    var id = $(this).data('codigobarra'),
			    removeBtn = $(this).find('.danger');
			});
			
			$('.confirm-delete').on('click', function(e) {
			    e.preventDefault();
			
			    var codigobarra = $(this).data('codigobarra');
			    $('#myModal').data('codigobarra', codigobarra).modal('show');
			});
			
			$('#btnYes').click(function() {
			    // handle deletion here
			    var codigobarra = $('#myModal').data('codigobarra');
			    $('[data-codigobarra='+codigobarra+']').parents('tr').remove();
			    $('#myModal').modal('hide');
			});
			        
        });
        
        </script>
</body>
</html>