<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.unisa.etm.model.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	@SuppressWarnings("unchecked")
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Carica Consegna</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">

		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body " style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Carica Consegna&nbsp;</h5>
						</div>
						<form action="AggiungiConsegnaServlet" method="post"
							name="caricaConsegna">
							<div class="form-group">
								<label for="nomeConsegna"><b>Nome Consegna:</b></label> <input
									type="text" class="form-control"
									onchange="controlloNomeConsegna()" name="nomeConsegna" required>
							</div>
							<div class="form-group">
								<label for="descrizioneConsegna"><b>Descrizione
										Consegna:</b></label>
								<textarea class="form-control"
									onchange="controlloDescrizioneConsegna()"
									name="descrizioneConsegna" rows="4" required></textarea>
							</div>
							<div class="form-group">
								<label for="scadenaConsegna"><b>Scadenza Consegna:</b></label> <input
									type="date" class="form-control"
									onchange="controlloScadenzaConsegna()" name="scadenzaConsegna"
									required>
							</div>
							<%
								if (consegne.size() < 5) {
							%>
							<div class="col text-center">
								<div id="infoDiv" class="alert alert-danger form-group d-none"
									role="alert"></div>
								<button type="submit" id="caricaFile" name="caricaFile"
									class="btn btn-primary" onclick="return validazione()">Aggiungi</button>
							</div>
							<%
								} else {
							%>
							<h4>Hai raggiunto il numero massimo di consegne</h4>
							<%
								}
							%>
						</form>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 80vh;">
				<h4 class="font-italic">Lista Consegne</h4>
				<%
					if (consegne != null) {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">N° Consegna</th>
							<th scope="col">Nome</th>
						</tr>
					</thead>
					<%
						for (int i = 0; i < consegne.size(); i++) {
					%>
					<tbody>
						<tr>
							<th><a><%=i + 1%></a></th>
							<th><a
								href="VisualizzaInfoConsegnaServlet?idConsegna=<%=consegne.get(i).getId()%>"><%=consegne.get(i).getNome()%></a></th>
						</tr>

					</tbody>
					<%
						}
					%>
				</table>
				<%
					} else {
				%>
				<p>Non ci sono consegne assegnate</p>
				<%
					}
				%>

			</div>
		</div>
		</aside>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

	<script src="js/caricaConsegna.js"></script>
</body>
</html>