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
	@SuppressWarnings("unchecked")
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	@SuppressWarnings("unchecked")
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	Boolean disabilita=(Boolean)session.getAttribute("disabilita");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
    <meta content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Area privata condivisa</title>
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
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<% if((partecipazioni.size()>0)&&(disabilita!=null)){%>
							<form action="VisualizzaDettagliTesiServlet" method="get">
								<input type="hidden" name="propostatesi_id"
									value="<%=session.getAttribute("numeroTesiDocente") %>">
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
						<h5>Area disabilitata: clicca su una proposta tesi per attivarla</h5>
						<%} %>
						
							<%
								if (file != null) {
							%>
								<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">File</th>
										<th scope="col">Email Utente</th>
										<th scope="col">Valutazione</th>
									</tr>
								</thead>
							<%		
									for (int i = 0; i < file.size(); i++) {
							%>
								<tbody>
									<tr>
										<th scope="row"><i class="fa fa-file fa" aria-hidden="true"></i></th>
										<td>
										<a href="VisualizzaInfoFileServlet?nomeFile=<%=file.get(i).getNome()%>&idTesi=<%=file.get(i).getPropostaTesiId()%>">
										<%=file.get(i).getNome()%>
										</a>
										</td>
										<td><%=file.get(i).getEmail()%></td>
										<%if(file.get(i).getEmail().equals(utente.getEmail())){ %>
										<td></td>
										<%}
										else if(file.get(i).getVoto()!=0) {%>
											<td><%=file.get(i).getVoto()%></td>
										<%} else if(file.get(i).getVoto()==0){%>
											<td>Non valutato</td>
										<%} %>
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

			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 30vh;">
				<h4 class="font-italic">Info Proposta Tesi</h4>
			<ol class="list-unstyled mb-0">
				<li><a href="#">Utente 1</a></li>
				<li><a href="#">Utente 2</a></li>
				<li><a href="#">Utente 3</a></li>
			</ol>
			</div>
			
			<div class="p-3 card my-4" style="min-height: 40vh;">
			<h4 class="font-italic">Aree</h4>
				<%
						if (partecipazioni != null) {
					%>
				<div class="row">
					<div class="col">
						<b>Proposta Tesi</b>
					</div>
					<div class="col">
						<b>Email Studente</b>
					</div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
					<%for (int i = 0; i < partecipazioni.size(); i++) { %>
					<div class="col">
						<a
							href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>&emailUtente=<%=partecipazioni.get(i).getUtenteEmail()%>"><%=partecipazioni.get(i).getPropostaTesiId() %></a>
					</div>
					<div class="col">
						<a
							href="VisualizzaProfiloUtenteServlet?utente_email=<%=partecipazioni.get(i).getUtenteEmail()%>"><%=partecipazioni.get(i).getUtenteEmail() %></a>
					</div>
					<div class="w-100" style="border-bottom: 1px solid"></div>
					<%
						}
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