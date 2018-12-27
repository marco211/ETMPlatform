<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.* "%>  

<%
PropostaTesi propostatesi = (PropostaTesi) session.getAttribute("propostatesi");
if(propostatesi==null){
	response.sendRedirect("./index.jsp");
    return;
}

Utente utente = (Utente) session.getAttribute("utente");
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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Home</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>

	<div style="background-color: #FF9C08; min-height: 81vh;">
	<main role="main" class="container">
 			
 	<div class="jumbotron jumbotron-fluid">
  		<div class="container">
    		<h1 class="display-4"><%=propostatesi.getTitolo()%></h1>
    		<p class="lead"><%=propostatesi.getDecrizione()%></p>
    			<%
    			ArrayList<Utente> utenti = (ArrayList<Utente>)session.getAttribute("utenti");
    			if(utente.getEmail().equals(propostatesi.getUtenteEmail())){
    			if(!propostatesi.isChiuso()){%>
    			<a class="col" href="ChiudiPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>" class="btn btn-primary col-2 my-2" id="ChiudiProposta">Chiudi</a>
    			<%} %>
    			<%if(propostatesi.isChiuso()){%>
    			<p>la proposta di tesi è chiusa</p>
    			<%} %>
    			<%if(!propostatesi.isArchiviato()){ %>				
    	    	<a class="col" href="ArchiviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>" class="btn btn-primary col-2 my-2" id="ArchiviaProposta">Archivia</a>				
    			<% }int count = 0;
    		        session.setAttribute("count", count);%>
    			<%boolean b = false;
    			for(Utente u : utenti){
    					if(u.getPropostaTesi_ID()==propostatesi.getId())
    						b = true;
    			}if(!b){
    			%>
    			<a class="col" href="RimuoviPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>" class="btn btn-inline col-2 my-2 px-2 mx-2 bg-warning" id="RimuoviProposta">Elimina</a>
    			<a class="col" href="ModificaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>"" class="btn btn-inline col-2 my-2 px-2 mx-2 bg-warning" id="ModificaProposta">Modifica</a>
    			<%}else{ %>
    			<p>Non puoi modificare o eliminare questa proposta di tesi perchè uno o più studenti vi stanno partecipando</p>
    			<%}} %>
  		</div>
	</div>	
 
 
 
 
 
 
 
 
 
 
 
 
 
     </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>