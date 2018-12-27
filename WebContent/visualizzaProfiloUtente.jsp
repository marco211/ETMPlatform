<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* "%>

<%
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
    <title>ETM Platform - Profilo utente</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>


<div style="background-color: #FF9C08">
<main role="main" class="container">
      <div class="row" >  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body"> 			
   			 <h5 class="card-title" style="color:#3385ff">Informazioni Personali</h5>
   			 	<div class="row" style="border-bottom: 1px solid;"></div>
    		 		<h4>Nome:</h4>
    		 			<a class="col-3"><%=utente.getNome()%></a>
    		 		<h4>Cognome:</h4>
    		 			<a class="col-3"><%=utente.getCognome()%></a>
    		 		<h4>Email:</h4>
    		 			<a class="col-3"><%=utente.getEmail()%></a>
    		 		<%if(utente.getTipo().equals("s")){%>
    		 		<h4>Matricola</h4>
    		 			<a class="col-3"><%=utente.getMatricola()%></a>
    		 			<% }%>
    		 			<%if(utente.getTipo().equals("d")){%>
    		 			<h4>Ufficio</h4>
		              		<a class="col-3"><%=utente.getUfficio()%></a>	
		              	<h4>Insegnamento</h4>
		              		<a class="col-3"><%=utente.getInsegnamento()%></a>		
		              	<% }%>
		              	</div>
		              </div>
    		 		<div class="col-sm-10 offset-sm-1 text-center mt-3">
    		 			<p>
    		 			<form method="get" action="modificaProfiloUtente.jsp">
    		 				<button type="submit" class="btn btn-primary mx-2" id="ModificaProfilo">Modifica profilo
    		 				</button>
    		 			</form>
    		 			<form method="get" action="modificaPassword.jsp">
    		 				<button type="button" class="btn btn-primary mx-2">Modifica password
    		 				</button>
    		 			</form>
    		 			</p>
    		 		</div>
 		    </div>
	</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Le mie proposte tesi attive</h4>
            <ol class="list-unstyled mb-0">
            <div class="row" style="border-bottom: 1px solid;"></div>
            <div class="card my-2" style="border: 1px solid;">
              <li><a href="#">Proposta tesi 1 <span class="fas fa-exclamation-circle"></span></a></li>
             </div>
             <div class="card my-2" style="border: 1px solid;">
              <li><a href="#">Proposta tesi 2</a></li>
             </div>
             <div class="card my-2" style="border: 1px solid;">
              <li><a href="#">Proposta tesi 3 <span class="fas fa-exclamation-circle" onmouseover="visualizzaMessaggio()"></span></a></li>
             </div>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>