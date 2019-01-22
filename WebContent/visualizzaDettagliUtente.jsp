<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.model.bean.*"%>

<%
Utente utente = (Utente) session.getAttribute("utenteemail");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Area admin</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h5 class="card-title" style="color: #3385ff">Informazioni
					Personali</h5>
				<div class="row" style="border-bottom: 1px solid;"></div>
				<h1 class="display-4"><%=utente.getNome()+" "+utente.getCognome()%></h1>
				<p class="lead">
					Email:
					<%=utente.getEmail()%></p>
				<p class="lead">
					Matricola:
					<%=utente.getMatricola()%></p>
				<p class="lead">
					Data Di Nascita:
					<%=utente.getDataDiNascita()%></p>
				<%if(utente.getTipo().equalsIgnoreCase("d")){ %>
				<p class="lead">
					Ufficio:
					<%=utente.getUfficio()%></p>
				<%} %>

				<h4>
					<a class="col-3" href="ListaUtentiServlet"><i
						class="fas fa-arrow-circle-left"></i></a>
				</h4>
			</div>
		</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>