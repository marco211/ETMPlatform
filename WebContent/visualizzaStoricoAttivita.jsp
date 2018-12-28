<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}

	PropostaTesi tesi = (PropostaTesi) session.getAttribute("propostaTesi");
	@SuppressWarnings("unchecked")
	ArrayList<Attivita> attivita = (ArrayList<Attivita>) session.getAttribute("storico");
	@SuppressWarnings("unchecked")
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	@SuppressWarnings("unchecked")
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
	@SuppressWarnings("unchecked")
	ArrayList<PropostaTesi> listaTesi = (ArrayList<PropostaTesi>) session.getAttribute("listaTesiDocente");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Storico attivita'</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
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
							<li class="list-group-item"><%=attivita.get(i).toString()%></li>
							<%
								}
								}
							%>
						</ul>

					</div>
				</div>

			</div>


			<aside class="col-md-4 my-4"> <%
 	if (utente.getTipo().equals("d")) {
 %>
			<div class="p-3 card" style="min-height: 35vh;">
				<h4 class="font-italic">Info Proposta Tesi</h4>
				<ol class="list-unstyled mb-0">
					<%
						for (int i = 0; i < partecipazioni.size(); i++) {
								if (partecipazioni.get(i)
										.getPropostaTesiId() == (int) request.getSession().getAttribute("numeroTesiDocente")) {
					%>
					<li><a
						href="VisualizzaProfiloUtenteServlet?utente_email=<%=partecipazioni.get(i).getUtenteEmail()%>"><%=partecipazioni.get(i).getUtenteEmail()%></a></li>
					<%
						}
							}
					%>
				</ol>
			</div>

			<div class="p-3 card my-4" style="min-height: 35vh;">
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
							href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>"><%=partecipazioni.get(i).getPropostaTesiId() %></a>
					</div>
					<div class="col">
					<%for(int x=0;x<listaTesi.size();x++) {
							if(listaTesi.get(x).getId()==j){
						%>
							<%=listaTesi.get(x).getTitolo() %>
						<%}} %>
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
			<div class="p-3 card" style="min-height: 35vh;">
				<h4 class="font-italic"><%=tesi.getTitolo()%></h4>
				<h6><%=tesi.getDecrizione()%></h6>
			</div>

			<div class="p-3 card my-4" style="min-height: 35vh;">
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

			</div>
			<%
				}
			%> </aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>