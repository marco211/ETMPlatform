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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storico Attivita</title>
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
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Proposta tesi</th>
							<th scope="col">Email studente</th>
						</tr>
					</thead>
					<tbody>
					<%for (int i = 0; i < partecipazioni.size(); i++) { %>
						<tr>
							<td><%=partecipazioni.get(i).getPropostaTesiId() %></td>
							<td><%=partecipazioni.get(i).getUtenteEmail() %></td>
							<td><a href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>&emailUtente=<%=partecipazioni.get(i).getUtenteEmail()%>">Visualizza</a></td>
						</tr>
						<%
						}
					%>
					</tbody>
					</table>
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