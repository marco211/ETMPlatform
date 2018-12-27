<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* ,java.util.*"%>

<%
Utente utente =(Utente)session.getAttribute("utente");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}
ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
if ((partecipazioni == null)&&(utente.getTipo().equals("d"))) {
	response.sendRedirect("./VisualizzaListaPartecipazioneServlet?action=esegui");
	return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Home</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>

<div style="background-color: #FF9C08; min-height: 81vh;">
<main role="main" class="container">
      <div class="row">  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body">
  				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  					<ol class="carousel-indicators">
   					 <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    				 <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    				 <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  					</ol>
 			 		<div class="carousel-inner">
    					<div class="carousel-item active">
      						<img  src="https://www.unisa.it/uploads/rescue/__thumbs/800x300_be459113aba7821dcbc63577fbafa913.jpg">
    					</div>
   					    <div class="carousel-item">
     					  	<img src="https://www.unisa.it/uploads/rescue/__thumbs/800x300_14b58263a478a8cd45474fff709d7313.jpg">
    					</div>
   						<div class="carousel-item">
     					 	<img src="https://www.radiobussola.it/wp-content/uploads/2016/03/verso800x300.jpg">
   						</div>
  					</div>
 					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
   					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
   					<span class="sr-only">Previous</span>
  					</a>
 					<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    				<span class="carousel-control-next-icon" aria-hidden="true"></span>
   					<span class="sr-only">Next</span>
 					</a>
  			</div>
 			
   			 <h5 class="card-title">Descrizione del Sito</h5>
    		 <p class="card-text">Il servizio offerto da questo sito cerca di agevolare gli studenti che sono in cerca di un docente il quale possa curare la proposta di tesi.</p>
 		    </div>
</div>
         
        </div>
        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Nome Sezione</h4>
            <ol class="list-unstyled mb-0">
              <li><a href="#">Primo elemento</a></li>
              <li><a href="#">Secondo elemento</a></li>
              <li><a href="#">Terzo elemento</a></li>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>
