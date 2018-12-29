<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente==null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	Consegna consegna = (Consegna) session.getAttribute("infoConsegna");
	@SuppressWarnings("unchecked")
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
    <meta content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Informazioni consegna</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />


	<div style="background-color: #FF9C08; min-height: 81vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body" style="min-height: 80vh;">

						<h5 class="card-title" style="color: #3385ff">Consegna</h5>
						<div class="row" style="border-bottom: 1px solid;"></div>
						
							<h4>Nome Consegna:</h4>
							<%=consegna.getNome() %>
							<h4>Descrizione Consegna:</h4>
							<%=consegna.getDescrzione() %>
							<h4>Scadenza Consegna:</h4>
							<%=consegna.getScadenza() %>
							
					</div>
				</div>

			</div>

			<aside class="col-md-4 my-4">

			<div class="p-3 card" style="min-height: 80vh;">
				<h4 class="font-italic">Impostazioni</h4>
				<ol class="list-unstyled mb-0">
					<div class="row" style="border-bottom: 1px solid;"></div>
					<%
						if ((utente.getTipo().equals("d"))) {
					%>
						<li>Modifica Consegna</li>
						<li>Elimina Consegna</li>
					<%
						}else if (utente.getTipo().equals("s")){
					%>
						<%
							for (int i = 0; i < consegne.size(); i++) {
					%>
					<li class="list-group-item"><a href="#"> <%=
								consegne.get(i).getNome()
							%>
					</a></li>
					<%
						}
						}
					%>
				</ol>
			</div>

			</aside>

		</div>

		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>