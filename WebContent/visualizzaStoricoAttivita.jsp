<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	ArrayList<Attivita> attivita = (ArrayList<Attivita>) session.getAttribute("storico");
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Storico attivita'</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08; min-height: 81vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3" style="min-height: 80vh;">
					<div class="card-body">
						<form class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Storico&nbsp;</h5>
						</form>

						<ul class="list-group list-group-flush">
							<%
								if (attivita != null) {
									for (int i = 0; i < attivita.size(); i++) {
							%>
							<li class="list-group-item"><%= attivita.get(i).toString()
									%></li>
							<%
								}
								}
							%>
						</ul>

					</div>
				</div>

			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 80vh;">
				<%
					if (utente.getTipo().equals("d")) {
				%>
				<h4 class="font-italic">Aree</h4>
				<div class="row">
					<div class="col"><b>Proposta Tesi</b></div>
					<div class="col"><b>Email Studente</b></div>
					<div class="col"></div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
					<%for (int i = 0; i < partecipazioni.size(); i++) { %>
					<div class="col"><a href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>&emailUtente=<%=partecipazioni.get(i).getUtenteEmail()%>"><%=partecipazioni.get(i).getPropostaTesiId() %></a></div>
					<div class="col"><a href="VisualizzaProfiloUtenteServlet?utente_email=<%=partecipazioni.get(i).getUtenteEmail()%>"><%=partecipazioni.get(i).getUtenteEmail() %></a></div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
						<%
						}
					%>
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

</body>
</html>