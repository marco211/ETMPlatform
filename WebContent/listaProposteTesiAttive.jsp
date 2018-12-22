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

<jsp:include page="header.jsp"/>

<div style="background-color: #FF9C08">
<main role="main" class="container">

      <div class="row">  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body">
   			 <form class="form-inline mb-3 pb-3" style="border-bottom:1px solid">
   			 	<h5 class="card-title mb-1">Proposte tesi&nbsp;</h5>
      			<input class="form-control form-control-sm mr-3 w-50" type="text" placeholder="Cerca proposta" aria-label="Cerca proposta">
				<button type="button" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="CercaProposta"><span class="fa fa-search"></span> </button>
					<% 
					if (utente.getTipo().equals("d")) {
					%>
					<a href="aggiungiPropostaTesi.jsp" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddProposta"><i class="fas fa-plus-circle"></i></a>				
				 <% }%>
			</form>
			
    		 <ol class="list-unstyled mb-0">
    		        <% ArrayList<PropostaTesi> proposte =(ArrayList<PropostaTesi>)request.getAttribute("proposte");
		   			for(PropostaTesi p : proposte)
		 			  {
					%>
		              <li><a href="#"><%= p.getTitolo() %></a><a href="InviaPropostaTesiServlet?propostatesi_id=<%=p.getId()%>" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="AddRichiesta"><i class="fas fa-plus-circle"></i></a>				
		              </li>
					<%} %>
      
            </ol>
 		    </div>
</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Statistiche</h4>
            <ol class="list-unstyled mb-0">

              <li><a href="#">Statistica uno</a></li>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>