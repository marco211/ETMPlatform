<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.* "%>  

<%
Utente docente = (Utente) session.getAttribute("docente");
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

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Dettagli proposta tesi</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>

	<div style="background-color: #FF9C08; min-height: 81vh; padding-top: 10px">
	<main role="main" class="container bg-white">
 			
 	<div class="jumbotron jumbotron-fluid bg-white row">
  		<div class="container-fluid bg-white col">
    		<h1 class="display-4"><%=propostatesi.getTitolo()%></h1>
    		<p class="lead"><%=propostatesi.getDecrizione()%></p>
			<p class="lead"><%=propostatesi.getAmbito()%></p>
		    	
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
    		        <a class="col" href="ModificaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>"" class="btn btn-inline col-2 my-2 px-2 mx-2 bg-warning" id="ModificaProposta">Modifica</a>
    			<%boolean b = false;
    			for(Utente u : utenti){
    					if(u.getPropostaTesi_ID()==propostatesi.getId())
    						b = true;
    			}if(!b){
    			%>
    			<a class="col" href="RimuoviPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>" class="btn btn-inline col-2 my-2 px-2 mx-2 bg-warning" id="RimuoviProposta">Elimina</a>
    			
    			<%}else{ %>
    			<p>Non puoi o eliminare questa proposta di tesi perchè uno o più studenti vi stanno partecipando</p>
    			<%}}%>
    			
    					
    			<p>Autore: <%=docente.getCognome()%>, <%=docente.getNome() %></p>
    			<a class="alert-link"href="VisualizzaProfiloUtenteServlet?utente_email=<%=docente.getEmail() %>"><%=docente.getEmail()%></a>
    			<%
    			boolean b = false;
    			ArrayList<RichiestaPartecipazione> richieste =(ArrayList<RichiestaPartecipazione>)request.getAttribute("richiesteproposte");
    			if(utente.getPropostaTesi_ID()!=propostatesi.getId()) {
    				for(RichiestaPartecipazione r : richieste){
    					if(r.getPropostatesi_id()==propostatesi.getId()){
    						b = true;
    					}
    				}if(!b){
    				%>
    			<a class="alert-link" href="InviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddRichiesta"><i class="fas fa-plus-circle">Invia Richiesta Proposta Tesi&nbsp;</i></a>
    			<%}else{%>
    			<p>Hai già inviato una richiesta di partecipazione</p>
    			<%}} %>
  		</div>
  		 <div class="container-fluid bg-white border-left col" style="width: 10px">
  		 	<p>Materia/e: <%=propostatesi.getMaterie()%></p>
  		 	<p>Tempo di sviluppo: <%=propostatesi.getTempoDiSviluppo()%> giorni</p>
  		 	<p class="blockquote-footer">Autore: <a href="VisualizzaProfiloUtenteServlet?utente_email"><%=propostatesi.getUtenteEmail()%></a></p>
		</div>
	</div>	
 
 
 
 
 
 
 
 
 
 
 
 
 
     </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>