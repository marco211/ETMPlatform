<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente==null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	//File file = new File("Primo", 1, "eurofilo", 0,"", "f@unisa.it"); 
	File file = (File) session.getAttribute("infoFile");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informazioni File</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp" />


	<div style="background-color: #FF9C08">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">

						<h5 class="card-title" style="color: #3385ff">File</h5>
						<div class="row" style="border-bottom: 1px solid;"></div>
						
							<h4>Nome File:</h4>
							<%=file.getNome() %>
							<h4>Descrizione File:</h4>
							<%=file.getDescrizione() %>
							<%if(file.getVoto()!=0){ %>
							<h4>Voto:</h4>
							<%=file.getVoto() %>
							<h4>Descrizione voto:</h4>
							<%=file.getDescrizioneVoto() %>
							<%} %>
						
					</div>
				</div>

			</div>

			<aside class="col-md-4 my-4">

			<div class="p-3 card">
				<h4 class="font-italic">Impostazioni</h4>
				<ol class="list-unstyled mb-0">
					<div class="row" style="border-bottom: 1px solid;"></div>
					<li><a href="ScaricaFileServlet?nomeFile=<%=file.getNome()%>&tesiID=<%=file.getPropostaTesiId()%>">Scarica file</a></li>
					<%
						if (utente.getTipo().equals("d")) {
					%>
					<li><a href="valutaFile.jsp">Valuta file</a></li>
					<%
						}
					%>
					<li><a href="EliminaFileServlet?idTesi=<%=file.getPropostaTesiId()%>&nomeFile=<%=file.getNome()%>">Elimina file</a></li>
				</ol>
			</div>

			</aside>

		</div>

		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>