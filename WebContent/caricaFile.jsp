<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carica File</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body ">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Carica File&nbsp;</h5>
						</div>
						<form action="CaricaFileServlet" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="nome"><b>Nome File:</b></label> <input type="text"
									class="form-control" name="nomeFile" required>
							</div>
							<div class="form-group">
								<label for="descrizione"><b>Descrizione:</b></label>
								<textarea class="form-control" name="descrizioneFile" rows="4"
									required></textarea>
							</div>
							<div>
								<label for="File"><b>File:</b></label>
							</div>
							<div class="form-group">
								<input type="file" name="uploadFile">
							</div>
							<div class="col text-center">
								<button type="submit" id="caricaFile" name="caricaFile"
									class="btn btn-primary">Carica</button>
							</div>
						</form>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card">
				<%
					if (utente.getTipo().equals("d")) {
				%>
				<h4 class="font-italic">Aree</h4>
				<ul class="list-group list-group-flush">
					<%
						if (partecipazioni != null) {
								for (int i = 0; i < partecipazioni.size(); i++) {
					%>
					<li class="list-group-item"><a href="VisualizzaListaFileServlet?idTesi=<%=partecipazioni.get(i).getPropostaTesiId()%>&emailUtente=<%=partecipazioni.get(i).getUtenteEmail()%>"><label><%=partecipazioni.get(i).getPropostaTesiId() + " "
								+ partecipazioni.get(i).getUtenteEmail()%></label></a></li>
					<%
						}
							}
					%>
				</ul>
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