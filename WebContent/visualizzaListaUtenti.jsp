<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.tesi.*,  it.unisa.etm.bean.* "%>  
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Admin</title>

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
   			 	<h5 class="card-title mb-1">Lista Utenti &nbsp;</h5>
      			<input class="form-control form-control-sm mr-3 w-50" type="text" placeholder="Cerca utente" aria-label="Cerca utente">
				<button type="button" class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning " id="CercaUtente"><span class="fa fa-search"></span> </button>
				
			</form>
			
    		 <div class="container">
    		        <% ArrayList<Utente> utenti =(ArrayList<Utente>)request.getAttribute("utenti");
		   			for(Utente u : utenti)
		 			  {
					%>
					<div class="row">
						<a class="col-3" href="visualizzaDettagliUtenteServlet?utente_email=<%=u.getEmail() %>"><%= u.getNome()+" "+u.getCognome() %></a>
		               
		              	
		              </div>
					<%} %>
      
            </div>
 		    </div>
</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Informazioni</h4>
            Informazioni tecniche per l'admin.
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
