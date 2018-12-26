<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.* "%>  
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Proposta Tesi</title>

</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<jsp:include page="header.jsp"/>

	<div style="background-color: #FF9C08; min-height: 81vh;">
	<main role="main" class="container">

      <div class="row">  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body">
   			 <form class="form-inline mb-3 pb-3" style="border-bottom:1px solid">
   			 	<h5 class="card-title mb-1">Proposte tesi&nbsp;</h5>
      			<input class="form-control form-control-sm mr-3 w-50" id="myInput" type="text" placeholder="Cerca proposta" aria-label="Cerca proposta">
					<% 
					if (utente.getTipo().equals("d")) {
					%>
					<a href="aggiungiPropostaTesi.jsp" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddProposta"><i class="fas fa-plus-circle"></i></a>				
				 <% }%>
			</form>
			
    		 <div class="container">
    		        <% ArrayList<PropostaTesi> proposte =(ArrayList<PropostaTesi>)request.getAttribute("proposte");
    		        int count = 0;
    		        session.setAttribute("count", count);
		   			for(PropostaTesi p : proposte)
		 			  {
					%>
					<div class="row" id="lista">
						<a class="col-3" href="VisualizzaDettagliTesiServlet?propostatesi_id=<%=p.getId() %>"><%= p.getTitolo() %></a>
		               <div>
		               <%if(utente.getEmail().equals(p.getUtenteEmail())){ %>
		               <a class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " href="ModificaPropostaTesiServlet?propostatesi_id=<%=p.getId() %>"">Modifica&nbsp;<i class="fas fa-dice-d6"></i></a>				
		               <% }
					if (utente.getTipo().equals("d")) {
						if((p.isArchiviato())&&(!p.isChiuso())){
					%>
				 
				 	<p class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " ><i class="fas fa-archive"></i></p>				
				 <%}else if(p.isChiuso()){%>
				 <p class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "><i class="fas fa-door-closed"></i></p>				
				 <%}} %>
		              	<% 
		              	if(utente.getTipo().equals("s")){
		              	%>
		              		<a class="col" href="InviaPropostaTesiServlet?propostatesi_id=<%=p.getId() %>" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddRichiesta"><i class="fas fa-plus-circle"></i></a>				
		              	<% }%>
		              	</div>
		              	
		              </div>
					<%} %>
      
            </div>
 		    </div>
</div>
         
        </div>
		<% if(utente.getTipo().equals("d")){ %>
        <aside class="col-md-4 my-4">
          <div class="p-3 card">
            <h4 class="font-italic">Richieste ricevute</h4>
            		<% ArrayList<RichiestaPartecipazione> richieste =(ArrayList<RichiestaPartecipazione>)request.getAttribute("richieste");
		   			  int c=0;
        			  for(RichiestaPartecipazione r : richieste)
		 			  {
        				  c++;
					%>
						<div class="row border border-dark bg-info mx-3 px-1"><%=c%>)Richiesta effettuata il giorno <%=r.getData()%> da parte di <%=r.getUtente_mail()%>
							<div class="btn-group mx-5 px-3">
							<a href="AccettaRichiestaServlet?richiesta_id=<%=r.getId()%>&utente_email=<%=r.getUtente_mail()%>" class="btn btn-primary" id="AccettaRichiesta">Accetta</a>				
							<a href="RifiutaRichiestaServlet?richiesta_id=<%=r.getId()%>&utente_email=<%=r.getUtente_mail()%>" class="btn btn-primary" id="RifiutaRichiesta">Rifiuta</a>					
							</div>
						</div>
					<%} %>
          </div>
   
        </aside>
		<% }else{ %>
		 <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Statistiche</h4>
            <ol class="list-unstyled mb-0">

              <li><a href="#">Statistica uno</a></li>
            </ol>
          </div>
   
        </aside>
		<% }%>
      </div>

    </main>
</div>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#lista *").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<jsp:include page="footer.jsp" />

</body>
</html>