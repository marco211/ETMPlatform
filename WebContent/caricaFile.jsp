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
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	@SuppressWarnings("unchecked")
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	@SuppressWarnings("unchecked")
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
	@SuppressWarnings("unchecked")
	ArrayList<PropostaTesi> listaTesi = (ArrayList<PropostaTesi>) session.getAttribute("listaTesiDocente");
	String errore = (String) request.getAttribute("carica");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Carica file</title>
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
							<h5 class="card-title mb-1">Carica File&nbsp;</h5>
						</div>
						<form action="CaricaFileServlet" method="post"
							enctype="multipart/form-data" name="carica">
							<div class="form-group">
								<label for="nomeFile"><b>Nome File:</b></label> <input
									type="text" class="form-control" onchange="controlloNome()"
									name="nomeFile" required>
							</div>
							<div class="form-group">
								<label for="descrizioneFile"><b>Descrizione:</b></label>
								<textarea class="form-control" onchange="controlloDescrizione()"
									name="descrizioneFile" rows="6" required></textarea>
							</div>
							<div>
								<label for="File"><b>File:</b></label>
							</div>
							<div class="form-group">
								<input type="file" name="uploadFile" id="uploadFile" required>
							</div>
							<div class="col text-center">
								<div id="infoDiv" class="alert alert-danger form-group d-none"
									role="alert"></div>
								<button type="submit" id="caricaFile" name="caricaFile"
									class="btn btn-primary" onclick="validazione()">Carica</button>
							</div>
							<%
								if (errore != null) {
							%>
							<div class="alert alert-danger form-group">
								<p><%=errore.toString()%></p>
							</div>
							<%
								}
							%>
						</form>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 80vh;">
				<%
					if (utente.getTipo().equals("d")) {
				%>
				<h4 class="font-italic">Aree</h4>
				<%
					if (partecipazioni != null) {
				%>
				<div class="row">
					<div class="col">
						<b>Proposta Tesi</b>
					</div>
					<div class="col">
						<b>Nome Proposta Tesi</b>
					</div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
					<%
						int j = 0;
								for (int i = 0; i < partecipazioni.size(); i++) {
									if (partecipazioni.get(i).getPropostaTesiId() != j) {
										j = partecipazioni.get(i).getPropostaTesiId();
					%>
					<div class="col">
						<a
							href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>"><%=partecipazioni.get(i).getPropostaTesiId()%></a>
					</div>
					<div class="col">
						<%
							for (int x = 0; x < listaTesi.size(); x++) {
												if (listaTesi.get(x).getId() == j) {
						%>
						<%=listaTesi.get(x).getTitolo()%>
						<%
							}
											}
						%>
					</div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
					<%
						}
								}
							}
					%>
				</div>

			</div>
			<%
				} else if (utente.getTipo().equals("s")) {
			%>
			<h4 class="font-italic">To Do List</h4>
			<ul class="list-group list-group-flush">
				<%
					if (consegne != null) {
							for (int i = 0; i < consegne.size(); i++) {
				%>
				<li class="list-group-item"><a href="#"> <%=consegne.get(i).getNome()%>
				</a></li>
				<%
					}
						}
				%>
			</ul>
			<%
				}
			%>
			
		</div>
		</aside>
	</div>
	</main>
	</div>

	<jsp:include page="footer.jsp" />

	<script src="js/caricaFile.js"></script>
</body>
</html>