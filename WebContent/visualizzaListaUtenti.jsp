<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.tesi.*,it.unisa.etm.model.bean.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Area admin</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		cambiaColore();
	});

	function cambiaColore() {
		document.getElementById("admin").className = "nav-link text-primary";
	};
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-12 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<form class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Lista Utenti &nbsp;</h5>
							<input class="form-control form-control-sm mr-3 w-50"
								id="myInput" type="text" placeholder="Cerca utente"
								aria-label="Cerca utente">
							<h3>
								<i class="fas fa-search"></i>
							</h3>

						</form>

						<div class="container">
							<%
								ArrayList<Utente> utenti = (ArrayList<Utente>) request.getAttribute("utenti");
							%>
							<table class="table table-striped">
								<%
									if (utenti != null) {
								%>
								<thead>
									<tr>
										<th scope="col">Nome e Cognome</th>
										<th scope="col">Elimina</th>
									</tr>
								</thead>
								<%
									for (int i = 0; i < utenti.size(); i++) {
								%>
								<tbody>
									<tr class="lista">
										<td><a
											href="VisualizzaDettagliUtenteServlet?utente_email=<%=utenti.get(i).getEmail()%>">
												<%=utenti.get(i).getNome() + " " + utenti.get(i).getCognome()%>
										</a></td>
										<td><a class="col-3"
											href="EliminaUtenteServlet?utente_email=<%=utenti.get(i).getEmail()%>"><i
												class="fas fa-user-minus"
												href="EliminaUtenteServlet?utente_email=<%utenti.get(i).getEmail();%>"></i></a></td>
									</tr>
								</tbody>
								<%
									}
									}
								%>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
	<script>
		$(document).ready(
				function() {
					$("#myInput").on(
							"keyup",
							function() {
								var value = $(this).val().toLowerCase();
								$(".lista").filter(
										function() {
											var tableRow = $(this);
											var anchorWithUserName = tableRow
													.find('a').first();
											if (anchorWithUserName.text()
													.toLowerCase().indexOf(
															value) > -1) {
												tableRow.show();
											} else {
												tableRow.hide();
											}
										});
							});
				});
	</script>
	<jsp:include page="footer.jsp" />

</body>