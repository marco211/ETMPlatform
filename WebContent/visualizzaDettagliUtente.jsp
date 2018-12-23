<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* "%>

<%
Utente utente = (Utente) session.getAttribute("utenteemail");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}

Utente ut = (Utente) session.getAttribute("utente");
if(ut==null){
	response.sendRedirect("./index.jsp");
    return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Home</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>

<div style="background-color: #FF9C08">
	<main role="main" class="container">
 			
 	<div class="jumbotron jumbotron-fluid">
  		<div class="container">
    		 <h5 class="card-title" style="color:#3385ff">Informazioni Personali</h5>
   			 	<div class="row" style="border-bottom: 1px solid;"></div>
    		 		<h4>Nome:</h4>
    		 			<%utente.getNome(); %>
    		 		<h4>Cognome:</h4>
    		 			<%utente.getCognome();%>
    		 		<h4>Email:</h4>
    		 			<%utente.getEmail();%>
    		 		<%if(utente.getTipo().equalsIgnoreCase("d")){ %>
    		 		<h4>Ufficio</h4>
    		 			<%utente.getUfficio(); %>
    		 		<h4>Insegnamento:</h4>
    		 			<%utente.getInsegnamento(); %>
    		 		<%} %>
    		 		<div class="col-sm-10 offset-sm-1 text-center mt-3">
    		 			
    		 			<p>
    		 				<button type="button" class="btn btn-primary mx-2">Elimina Utente</button>
    		 				
    		 			</p>
  		</div>
	</div>	
 
 
 
 
 
 
 
 
 
 
 
 
 
     </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>