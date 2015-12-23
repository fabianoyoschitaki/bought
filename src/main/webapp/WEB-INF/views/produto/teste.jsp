
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Bootply snippet - Bootstrap Table with edit delete row</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description"
	content="Bootstrap Table with edit delete row example snippet for Bootstrap." />
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css"
	rel="stylesheet">

<!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<link rel="apple-touch-icon" href="/bootstrap/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="/bootstrap/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="/bootstrap/img/apple-touch-icon-114x114.png">

<!-- CSS code from Bootply.com editor -->

<style type="text/css">
</style>
</head>

<!-- HTML code from Bootply.com editor -->

<body>

	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 id="myModalLabel">Delete</h3>
		</div>
		<div class="modal-body">
			<p></p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button data-dismiss="modal" class="btn red" id="btnYes">Confirm</button>
		</div>
	</div>
	<table class="table table-striped table-hover table-users">
		<thead>
			<tr>

				<th class="hidden-phone">Usuario</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th class="hidden-phone">Email</th>
				<th class="hidden-phone">Provincia</th>
				<th class="hidden-phone">Miembro desde</th>
				<th>Estado</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<tbody>

			<tr>

				<td class="hidden-phone">johnny</td>
				<td>john</td>
				<td>doe</td>
				<td class="hidden-phone">dsd@gmail.com</td>
				<td class="hidden-phone">active</td>
				<td class="hidden-phone">10/12/1999</td>

				<td><span class="label label-warning">Not Active</span></td>

				<td><a class="btn mini blue-stripe"
					href="{site_url()}admin/editFront/1">Edit</a></td>

				<td><a href="#" class="confirm-delete btn mini red-stripe"
					role="button" data-title="johnny" data-id="1">Delete</a></td>
			</tr>
			<tr>

				<td class="hidden-phone">kitty</td>
				<td>jane</td>
				<td>doe</td>
				<td class="hidden-phone">dasasasd@gmail.com</td>
				<td class="hidden-phone">active</td>
				<td class="hidden-phone">10/1/1999</td>

				<td><span class="label label-danger">Activo</span></td>

				<td><a class="btn mini blue-stripe"
					href="{site_url()}admin/editFront/2">Edit</a></td>

				<td><a href="#" class="confirm-delete btn mini red-stripe"
					role="button" data-title="kitty" data-id="2">Delete</a></td>
			</tr>

		</tbody>

	</table>

	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<script type='text/javascript'
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>







	<!-- JavaScript jQuery code from Bootply.com editor  -->

	<script type='text/javascript'>
		$(document)
				.ready(
						function() {

							$('#myModal')
									.on(
											'show',
											function() {
												var tit = $('.confirm-delete')
														.data('title');

												$('#myModal .modal-body p')
														.html(
																"Desea eliminar al usuario "
																		+ '<b>'
																		+ tit
																		+ '</b>'
																		+ ' ?');
												var id = $(this).data('id'), removeBtn = $(
														this).find('.danger');
											})

							$('.confirm-delete').on('click', function(e) {
								e.preventDefault();

								var id = $(this).data('id');
								$('#myModal').data('id', id).modal('show');
							});

							$('#btnYes').click(
									function() {
										// handle deletion here
										var id = $('#myModal').data('id');
										$('[data-id=' + id + ']').parents('tr')
												.remove();
										$('#myModal').modal('hide');

									});

						});
	</script>

	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-40413119-1', 'bootply.com');
		ga('send', 'pageview');
	</script>


</body>
</html>
