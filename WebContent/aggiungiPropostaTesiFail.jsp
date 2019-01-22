<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.tesi.*,it.unisa.etm.model.bean.*, java.time.* "%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - TesiError</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>
	<%int count = (int)request.getAttribute("count"); %>
	<jsp:include page="header.jsp" />
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<section id="cover">
			<div id="cover-caption">
				<div id="container" class="container">
					<div class="row text-black">
						<div class="col-sm-10 offset-sm-1 text-center py-5">
							<img src="https://www.unisa.it/rescue/img/logo_cc.png"
								class="img-fluid" alt="Responsive image">
							<% if(count==1){%>
							<p>Proposta di tesi non aggiunta</p>

							<form action="AggiungiPropostaTesiServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Aggiungi
									una nuova proposta di tesi</button>
							</form>
							<%} %>
							<% if(count==2){%>
							<p>Problemi nell'accettazione della richiesta di
								partecipazione</p>

							<form action="ListaProposteTesiAttiveServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Torna
									all'area proposta tesi</button>
							</form>
							<%} %>
							<% if(count==3){%>
							<p>Problemi nella modifica della proposta di tesi</p>

							<form action="ListaProposteTesiAttiveServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Torna
									all'area proposta tesi</button>
							</form>
							<%} %>
							<% if(count==4){%>
							<p>Problemi nell'invio della richiesta di partecipazione</p>

							<form action="ListaProposteTesiAttiveServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Torna
									all'area proposta tesi</button>
							</form>
							<%} %>
							<% if(count==5){%>
							<p>Problemi nel rifiutare una richiesta di partecipazione</p>

							<form action="ListaProposteTesiAttiveServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Torna
									all'area proposta tesi</button>
							</form>
							<%} %>
							<% if(count==6){%>
							<p>Problemi nell'eliminazione di una richiesta di
								partecipazione</p>

							<form action="ListaProposteTesiAttiveServlet" method="post"
								class="form-inline justify-content-center">


								<button type="submit" class="btn btn-success ">Torna
									all'area proposta tesi</button>
							</form>
							<%} %>
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>