
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.unisa.etm.user.*,  it.unisa.etm.bean.* "%>  
<%
Utente utente = (Utente) session.getAttribute("utente");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Profilo Utente</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

</head>
<body>

<jsp:include page="header.jsp"/>


<div style="background-color: #FF9C08">
<main role="main" class="container">
      <div class="row" >  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body"> 			
   			 <h5 class="card-title" style="color:#3385ff">Modifica Informazioni Personali</h5>
   			 	<div class="row" style="border-bottom: 1px solid;"></div>
    		 		<h4>Nome:</h4>
    		 		<form action="ModificaProfiloUtenteServlet" method="post">
    		 	 	<input type="text" class="form-control" name="nome"
								placeholder="Nome"></form>
    		 		<h4>Cognome:</h4>
    		 			<form action="ModificaProfiloUtenteServlet" method="post">
    		 	 	<input type="text" class="form-control" name="cognome"
								placeholder="Cognome"></form>
    		 		<h4>Email:</h4>
    		 			<form action="ModificaProfiloUtenteServlet" method="post">
    		 	 	<input type="text" class="form-control" name="email"
								placeholder="E-mail"></form>
    		 		<%if(utente.getTipo().equals("s")){%>
    		 		<h4>Matricola</h4>
    		 			<form action="ModificaProfiloUtenteServlet" method="post">
    		 	 	<input type="text" class="form-control" name="matricola"
								placeholder="Matricola"></form>
					<% }%>
    		 			<%if(utente.getTipo().equals("d")){%>
		              		<form action="ModificaProfiloUtenteServlet" method="post">
    		 	 	<input type="text" class="form-control" name="ufficio"
								placeholder="Ufficio"></form>				
		              	<% }%>
		              	</div>
		              </div>
    		 		<div class="col-sm-10 offset-sm-1 text-center mt-3">
    		 			<p>
    		 			<form action="ModificaProfiloUtenteServlet">
    		 				<button type="submit" class="btn btn-primary mx-2" id="SalvaProfilo">Salva Profilo
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