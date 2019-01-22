<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.tesi.*,it.unisa.etm.model.bean.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Proposta Tesi</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
	 cambiaColore();
	});

function cambiaColore(){
	document.getElementById("areaTesi").className = "nav-link text-primary";
};
</script>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<form class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Proposte tesi&nbsp;</h5>
							<input class="form-control form-control-sm ml-5 w-50"
								id="myInput" type="text" placeholder="Cerca proposta"
								aria-label="Cerca proposta">

						</form>

						<table class="table table-striped">
							<% ArrayList<PropostaTesi> proposte =(ArrayList<PropostaTesi>)request.getAttribute("proposte");
    		        boolean b = false;
    		        session.setAttribute("richiesteproposte", proposte);
    		        PropostaTesi proposta = new PropostaTesi();
		   			for(PropostaTesi p : proposte)
		 			  {
		   				if(utente.getPropostaTesi_Id()==p.getId())
		   					proposta = p;
		   				if(utente.getPropostaTesi_Id()!=p.getId()){
		   				if((!p.isArchiviato())&&(!p.isChiuso())){
					%>
							<tr class="pt-1" id="lista">
								<td style="width: 60%; border-style: none"><a
									href="VisualizzaDettagliTesiServlet?propostatesi_id=<%=p.getId() %>"><%= p.getTitolo() %></a>
								</td>
								<td style="border-style: none">
									<%if(utente.getPropostaTesi_Id()==0){ %>
									<div>
										<%
		               ArrayList<RichiestaPartecipazione> richieste_studente = (ArrayList<RichiestaPartecipazione>)request.getAttribute("richieste_studente");
		               if(richieste_studente==null||richieste_studente.size()==0){
		            	   b=true;
		            	   %>
										<a class="col"
											href="InviaPropostaTesiServlet?propostatesi_id=<%=p.getId() %>"
											class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
											id="AddRichiesta" data-toggle="tooltip"
											data-placement="bottom"
											title="Invia richiesta di partecipazione"><i
											class="fas fa-plus-circle"></i></a>
										<% }
		               else{b=false;
		               for (RichiestaPartecipazione r : richieste_studente){
		            	   if(p.getId()==r.getPropostatesi_id())
		            		   b=true;
		               }if((!b)&&(utente.getPropostaTesi_Id()==0)){
		               %>
										<a class="col"
											href="InviaPropostaTesiServlet?propostatesi_id=<%=p.getId() %>"
											class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
											id="AddRichiesta" data-toggle="tooltip"
											data-placement="bottom"
											title="Invia richiesta di partecipazione"><i
											class="fas fa-plus-circle"></i></a>
										<%}} %>
										<%} %>
									
								</td>
							</tr>
							<%}}} %>

						</table>
					</div>
				</div>

			</div>
			<aside class="col-md-4 my-4">

				<div class="p-3 card">
					<h4 class="font-italic">Tesi a cui stai partecipando:</h4>
					<ol class="list-unstyled mb-0">
						<%int id = utente.getPropostaTesi_Id();
			if(id!=0){
			%>
						<li><a
							href="VisualizzaDettagliTesiServlet?propostatesi_id=<%=proposta.getId() %>"><%=proposta.getTitolo() %></a></li>
						<%} else{%>
						<p>Non stai partecipando ad alcuna tesi attualmente.</p>
						<%}%>
						<li>
					</ol>
				</div>

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