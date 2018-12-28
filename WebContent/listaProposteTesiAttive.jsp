<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.*, java.time.* "%>  
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
					
					<a href="aggiungiPropostaTesi.jsp" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddProposta"><i class="fas fa-plus-circle"></i></a>				
				 
			</form>
			
    		 <div class="container">
    		        <% ArrayList<PropostaTesi> proposte =(ArrayList<PropostaTesi>)request.getAttribute("proposte");
    		      
    		        int count = 0;
    		        session.setAttribute("count", count);
		   			for(PropostaTesi p : proposte)
		 			  {
					%>
					<div class="row pt-1" id="lista">
						<a class="col-5" href="VisualizzaDettagliTesiServlet?propostatesi_id=<%=p.getId() %>"><%= p.getTitolo() %></a>
		               <div>
		               <%if(utente.getEmail().equals(p.getUtenteEmail())){ %>
		               <a class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " href="ModificaPropostaTesiServlet?propostatesi_id=<%=p.getId() %>&propostatesi_titolo=<%=p.getTitolo()%>&propostatesi_ambito=<%=p.getAmbito()%>&propostatesi_tempo=<%=p.getTempoDiSviluppo()%>&propostatesi_descrizione=<%=p.getDecrizione()%>&propostatesi_materia=<%=p.getMaterie()%>">Modifica&nbsp;<i class="fas fa-edit"></i></a>				
		               <% }
					
						if((p.isArchiviato())&&(!p.isChiuso())){
					%>
				 
				 	<p class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " ><i class="fas fa-archive"></i></p>				
				 <%}else if(p.isChiuso()){%>
				 <p class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "><i class="fas fa-door-closed"></i></p>				
				 <%} %>
		              	
		              	</div>
		              	
		              </div>
					<%} %>
      
            </div>
 		    </div>
</div>
         
        </div>
		
        <aside class="col-md-4 my-4">
          <div class="list-group p-3 card">
            <h4 class="font-italic">Richieste ricevute</h4>
            		<% ArrayList<RichiestaPartecipazione> richieste =(ArrayList<RichiestaPartecipazione>)request.getAttribute("richieste");
		   			  int c=0;
		   			  String titolop = "";
        			  for(RichiestaPartecipazione r : richieste)
		 			  {
        				  c++;
        				  for (PropostaTesi p : proposte){
        				  	if(r.getPropostatesi_id()==p.getId())
        				  		titolop = p.getTitolo();
        				  }
        				  	
        				  Period tempo = Period.between(r.getData(), LocalDate.now());
					%>
						<div class="list-group-item list-group-item-action flex-column align-items-start mx-1 px-1 py-2">
							<div class="d-flex w-100">
								<div style="font-size:14px; padding: 10px; margin-right:15px ;text-align: center">
									<p  class="text-xs-center mb-1" >Nome</p>
									<a class="text-xs-center mt-1" href="VisualizzaProfiloUtenteServlet?utente_email"><%=r.getUtente_mail()%></a><br> 
									<p  class="text-xs-center mb-1 mt-3" >Tesi</p>
									<a class="text-xs-center mt-1" href="VisualizzaDettagliTesiServlet?propostatesi_id=<%=r.getPropostatesi_id() %>"><%=titolop %></a>
								</div>
								<div class="border-left pl-2 pr-1 pt-3 w-20">
									<div style="font-size: 14px">
									<%if(LocalDate.now().getYear()==r.getData().getYear()) 
										{
											if(LocalDate.now().getMonth().equals(r.getData().getMonth()))
											{
									%>
												<%=tempo.getDays()%> giorno/i fa
									<%		}else{ %>
											<%=tempo.getMonths()%> mese/i fa
									<%		}
										}else{%>
												<%=tempo.getYears()%> anno/i fa
									<%	}%>
									</div>
									<div class="mt-2" >
										<a href="AccettaRichiestaServlet?richiesta_id=<%=r.getId()%>&utente_email=<%=r.getUtente_mail()%>" class="btn btn-primary"  style="font-size: 10px;" id="AccettaRichiesta"><i class="fas fa-check-circle"></i></a>				
										<a href="RifiutaRichiestaServlet?richiesta_id=<%=r.getId()%>&utente_email=<%=r.getUtente_mail()%>" class="btn btn-primary"  style="font-size: 10px;" id="RifiutaRichiesta"><i class="fas fa-times-circle"></i></a>					
									</div>																		
									
							</div>
							</div>
							
						</div>
					<%}%>
   
        </aside>
		
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