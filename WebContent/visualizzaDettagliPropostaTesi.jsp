<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.* "%>  

<%
Utente docente = (Utente) session.getAttribute("docente");
PropostaTesi propostatesi = (PropostaTesi) request.getAttribute("propostatesi");
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
	<main role="main" class="container">
 			
 	<div class="row">
  		<div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body">
    			<div class="border-bottom border-solid mb-3 py-1">
    					<h3 class="card-title"><%=propostatesi.getTitolo()%></h3>
    			<%
    				ArrayList<Utente> utenti = (ArrayList<Utente>)request.getAttribute("utenti");
    				if(utente.getEmail().equals(propostatesi.getUtenteEmail())){
    				boolean b = false;
    				for(Utente u : utenti){
    						if(u.getPropostaTesi_ID()==propostatesi.getId())
    							b = true;
    				}if(b){
    				%>
    						
    				<p class="py-0 my-0" style="font-size: small;"><i class="fas fa-exclamation pr-2 mt-1"></i>Non puoi eliminare questa proposta di tesi perchè uno o più studenti vi stanno partecipando</p>
  
    			
    				<%}}%> 
    				<%if((propostatesi.isChiuso())&&(!propostatesi.isArchiviato())){%>
    				<p class="py-0 my-0" style="font-size: small;"><i class="fas fa-exclamation pr-2"></i>La proposta di tesi è <u data-toggle="tooltip" data-placement="bottom" title="La proposta tesi è terminata e non più accessibile a nuove richiesta">chiusa</u></p>
    				<%} %>
    				<%if(propostatesi.isArchiviato()){%>
    				<p class="py-0 my-0" style="font-size: small;"><i class="fas fa-exclamation pr-2"></i>La proposta di tesi è <u data-toggle="tooltip" data-placement="bottom" title="La proposta tesi è terminata e non più accessibile a nuove richiesta">archiviata</u></p>
    				<%} %>
    			</div>
        <table class="table border-bottom border-solid mb-3 py-1">
        
    						
    			<tr class="pt-1" id="lista">
								<td style="border-style: none">
    			<h5 class="font-weight-normal">Descrizione:
    			 <%=propostatesi.getDecrizione()%></h5>
    			 </td>
    			 </tr>
    			
    			<tr class="pt-1" id="lista">
								<td style="border-style: none">
				<p>Ambito: <%=propostatesi.getAmbito()%></p>
				</td>
					
    			</table>
				<small class="pt-3 font-weight-bold">Autore: <%=docente.getCognome()%>, <%=docente.getNome() %></small>
				
  		</div>
  	</div>	
  </div>		
  
  		 <aside class="col-md-4 my-4">
  		 	<div class="list-group p-3 card">
  		 	<div class="card-body">
  		 	<%if(utente.getEmail().equals(propostatesi.getUtenteEmail())){
    			if((!propostatesi.isChiuso())&&(!propostatesi.isArchiviato())){%>
    			<a class = "btn bg-warning " href="ChiudiPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>"  id="ChiudiProposta" data-toggle="tooltip" data-placement="bottom" title="Chiudi la proposta tesi: essa è terminata e non più accessibile a nuove richiesta"><i class="fas fa-door-closed "></i></a>
    			<%} %>
    			<%if(!propostatesi.isArchiviato()){ %>				
    	    	<a class = "btn bg-warning " href="ArchiviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>" id="ArchiviaProposta" data-toggle="tooltip" data-placement="bottom" title="Archivia la proposta tesi: essa è ancora in atto ma non più accessibile a nuove richiesta"><i class="fas fa-archive " style="display: inline"></i></a>				
    			
    		        <a class = "btn bg-warning "href="ModificaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>&propostatesi_titolo=<%=propostatesi.getTitolo()%>&propostatesi_ambito=<%=propostatesi.getAmbito()%>&propostatesi_tempo=<%=propostatesi.getTempoDiSviluppo()%>&propostatesi_descrizione=<%=propostatesi.getDecrizione()%>&propostatesi_materia=<%=propostatesi.getMaterie()%>"  id="ModificaProposta" data-toggle="tooltip" data-placement="bottom" title="Modifica la proposta tesi"><i class="fas fa-edit" style="display: inline"></i></a>
    			<% }%>
    			<%boolean b1 = false;
    			for(Utente u : utenti){
    					if(u.getPropostaTesi_ID()==propostatesi.getId())
    						b1 = true;
    			}if(!b1){
    			%>
    			<a  class = "btn bg-warning "  href="RimuoviPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>" " id="RimuoviProposta" data-toggle="tooltip" data-placement="bottom" title="Rimuovi la proposta tesi"><i class="fas fa-trash-alt"></i></a>
    			
    			<%}}else if(utente.getTipo().equals("d")){%>
    			<p>Questa non è una tua proposta di tesi</p>
    			<%}else{
    				boolean b2 = false;
    			ArrayList<RichiestaPartecipazione> richieste2 =(ArrayList<RichiestaPartecipazione>)request.getAttribute("richiesteproposte");
    			if(utente.getTipo().equals("s")){
    				if(utente.getPropostaTesi_ID()==0){
    			if(utente.getPropostaTesi_ID()!=propostatesi.getId()) {
    				for(RichiestaPartecipazione r : richieste2){
    					if(r.getPropostatesi_id()==propostatesi.getId()){
    						b2 = true;
    					}
    				}if(!b2){ %>
    			<a class="alert-link" href="InviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddRichiesta"><i class="fas fa-plus-circle">Invia richiesta di partecipazione&nbsp;</i></a>
    			<%}else{%>
    			<p>Hai già inviato una richiesta di partecipazione</p>
    			<%}}}}} %>
    			<hr>
  		 		<p>Materia/e: <%=propostatesi.getMaterie()%></p>
  		 		<hr>
  		 		<p>Tempo di sviluppo: <%=propostatesi.getTempoDiSviluppo()%> giorni</p>
  		 		<hr>
  		 		<a  href="VisualizzaProfiloUtenteServlet?utente_email=<%=docente.getEmail() %>"><i class="fas fa-user"></i>&nbsp; <%=docente.getEmail()%></a>
  		 		
    			</div>
			</div>
		</aside>
	</div>	
 	
 
 
     </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>