<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.model.bean.*,java.util.*"%>

<%
Utente utente =(Utente)session.getAttribute("utente");
Amministratore admin = (Amministratore)session.getAttribute("admin");
if(utente==null){
	if(admin==null){
		response.sendRedirect("./index.jsp");
		return;
	}
}else{
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	if ((partecipazioni == null)&&(utente.getTipo().equals("d"))) {
		response.sendRedirect("./VisualizzaListaPartecipazioneServlet?action=esegui");
		return;
	}
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
<title>ETM Platform - Home</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
	 cambiaColore();
	 getTesiRecenti();
	});


  function getTesiRecenti(){
	  var request=new XMLHttpRequest();
		var url="TesiRecentiServlet";
		request.onreadystatechange=function(){
			if(request.readyState==4){
				var val=request.responseText;
				$("#recenti").html(val);
			}
		}
		
		request.open("GET",url,true);
		request.send(null);
  };
function cambiaColore(){
	document.getElementById("home").className = "nav-link text-primary";
};
</script>

</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C);; min-height: 81vh;">
		<main role="main" class="container">
		<div class="row">
		<% if(admin==null){%>
			<div class="col-md-8 my-4">
			<%} else if(admin!=null) {%>
			<div class="col-md-12 my-4">
			<% }%>
				<div class="card mb-3">
					<div class="card-body" style="min-height: 84vh">
					<% if(admin!=null){%>
					<div class="mx-auto" style="width:600px;">
					<%} %>
						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="img/SlideShow1.png">
								</div>
								<div class="carousel-item">
									<img src="img/SlideShow2.jpg">
								</div>
								<div class="carousel-item">
									<img src="img/SlideShow3.jpg">
								</div>
							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
							<%if(admin!=null){ %>
							</div>
							<%} %>
						</div>

						<h5 class="card-title">
							Benevenuto in <b>ETM Platform</b>.
						</h5>

						<%if(admin==null){
    		 if(utente.getTipo().equals("s")){ %>
						<p class="card-text">
							Clicca su <b>Area Proposta Tesi</b> per per inviare una richiesta
							di partecipazione ad una Proposta Tesi caricata da un docente.
						</p>
						<p class="card-text">
							Appena un docente avrá accettato la tua richiesta di
							partecipazione, avrai libero accesso all'<b>Area Privata
								Condivisa</b> nella quale potrai svolgere in modo Smart la tua Tesi,
							seguendo le linee guida caricate dal Docente.
						</p>
						<%}else if(utente.getTipo().equals("d")){ %>
						<p class="card-text">
							Clicca su <b>Area Proposta Tesi</b> per per caricare una nuova
							Proposta Tesi, o per accettare una richiesta di partecipazione ad
							un Proposta Tesi ricevuta precedentemente.
						</p>
						<p class="card-text">
							Una volta accettata una richiesta di partecipazione, potrai
							gestire le Proposte Tesi tramite l'<b>Area Privata Condivisa</b>.
						</p>
						<%}
    		 }%>
						<p class="card-text">Puoi utilizzare la barra di ricerca per
							cercare un utente in modo semplice e veloce.</p>
					</div>
				</div>

			</div>
			<% if(admin==null){%>
			<aside class="col-md-4 my-4">
			<div class="p-3 card">
				<h4 class="font-italic">Tesi Recenti</h4>
				<div id="recenti"></div>
			</div>

			</aside>
			<%} %>
		</div>

		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>