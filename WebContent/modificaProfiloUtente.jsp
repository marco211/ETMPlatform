
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.user.*,  it.unisa.etm.bean.* "%>  
<%
Utente utente = (Utente) session.getAttribute("utente");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}
%>

<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>ETM Platform - Modifica Profilo</title>
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
  			<h5 class="card-title" style="color:#3385ff">Modifica Informazioni Personali</h5>
   			 	<div class="row" style="border-bottom: 1px solid;"></div>
   			 		
    		 		
    		 		<form action="ModificaProfiloUtenteServlet" method="post">
    		 		<h4>Nome:</h4>
    		 		<input type="hidden" name="tipo" value="<%=utente.getTipo()%>">
    		 	 	<input type="text" class="form-control" name="nome"
								placeholder="Nome">
    		 		<h4>Cognome:</h4>
    		 	 	<input type="text" class="form-control" name="cognome"
								placeholder="Cognome">
    		 		<h4>Data:</h4>
    		 	 	<input type="date" class="form-control" name="data"
								placeholder="Data">

    		 		<%if(utente.getTipo().equals("s")){%>
    		 		<h4>Matricola</h4>
    		 	 	<input type="text" class="form-control" name="matricola"
								placeholder="Matricola">
					<% }%>
    		 			<%if(utente.getTipo().equals("d")){%>
    		 	 	<input type="text" class="form-control" name="ufficio"
								placeholder="Ufficio">			
		              	<% }%>
		              	</div>
		              </div>
    		 		<div class="col-sm-10 offset-sm-1 text-center mt-3">
    		 				<button type="submit" class="btn btn-primary mx-2" id="SalvaProfilo">Salva Profilo
    		 				</button></form>	
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