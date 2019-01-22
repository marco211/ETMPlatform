<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.unisa.etm.model.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	Consegna consegna = (Consegna) request.getAttribute("infoConsegna");
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
<title>ETM Platform - Informazioni consegna</title>
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
					<div class="card-body" style="min-height: 80vh;">

						<h5 class="card-title">Info consegna</h5>
						<div class="row" style="border-bottom: 1px solid;"></div>
						<h4>Nome Consegna:</h4>
						<%=consegna.getNome()%>
						<h4>Descrizione Consegna:</h4>
						<%=consegna.getDescrzione()%>
						<h4>Scadenza Consegna:</h4>
						<div id="scadenzaConsegna"><%=consegna.getScadenza()%></div>
						<div class="d-none" id="modificaConsegnaDiv">
							<form action="ModificaConsegnaServlet" method="post"
								name="caricaConsegna">
								<input type="hidden" name="idConsegna"
									value="<%=consegna.getId()%>"> <input type="hidden"
									name="nomeConsegna" value="<%=consegna.getNome()%>"> <input
									type="hidden" name="descrizioneConsegna"
									value="<%=consegna.getDescrzione()%>">
								<div class="form-group">
									<input type="date" class="form-control"
										onchange="controlloScadenzaConsegna()" name="scadenzaConsegna"
										required>
								</div>
								<div id="infoDiv" class="alert alert-danger form-group d-none"
									role="alert"></div>
								<div>
									<input type="submit" class="btn btn-primary"
										onclick="return validazione()" value="modificaScadenza">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 80vh;">

				<%
					if ((utente.getTipo().equals("d"))) {
				%>
				<h4 class="font-italic">Impostazioni</h4>
				<ol class="list-unstyled mb-0">
					<div class="row" style="border-bottom: 1px solid;"></div>
					<li><a href="#" onclick="scadenza()">Modifica Consegna</a></li>
					<li><a
						href="EliminaConsegnaServlet?idConsegna=<%=consegna.getId()%>">Elimina
							Consegna</a></li>
				</ol>
				<%
					} else if (utente.getTipo().equals("s")) {
				%>
				<h4 class="font-italic">To Do List</h4>
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
					}
					}
				%>
			</div>
			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />
	<script type="text/javascript" src="js/consegna.js"></script>
</body>
</html>