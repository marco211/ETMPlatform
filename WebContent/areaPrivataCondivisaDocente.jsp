<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	if (utente.getTipo().equals("s")) {
		response.sendRedirect("./areaPrivataCondivisaStudente.jsp");
		return;
	}
	
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	Boolean disabilita=(Boolean)session.getAttribute("disabilita");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Privata Condivisa</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08; min-height: 81vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body" style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<% if((partecipazioni.size()>0)&&(disabilita!=null)){%>
						<form action="VisualizzaDettagliTesiServlet" method="get">
								<input type="hidden" name="propostatesi_id" value="<%=session.getAttribute("numeroTesiDocente") %>">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="AddFile">
									<i class="fa fa-info-circle" aria-hidden="true"></i>
								</button>
							</form>
							<form action="VisualizzaStoricoServlet" method="get">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="VisualizzaArchivio">
									<span class="fa fa-archive"></span>
								</button>
							</form>
							<form action="caricaFile.jsp">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="AddFile">
									<i class="fas fa-plus-circle"></i>
								</button>
							</form>
							<%}%>
						</div>
						<%if((disabilita==null) &&(partecipazioni.size()>0)){ %>
						<h5>Area disabilitata: visualizza un area per attivarla</h5>
						<%} %>
						<ul class="list-group list-group-flush">
								<%
									if (file != null) {
										for (int i = 0; i < file.size(); i++) {
								%>
								<li class="list-group-item"><a
									href="VisualizzaInfoFileServlet?nomeFile=<%=file.get(i).getNome()%>&idTesi=<%=file.get(i).getPropostaTesiId()%>"> <%=file.get(i).getNome()%>
								</a></li>
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
				<h4 class="font-italic">Aree</h4>
					<%
						if (partecipazioni != null) {
					%>
					<!--  
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
					<%} %>
					-->
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
			</div>
			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>