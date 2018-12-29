<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* "%>

<%
Utente utente = (Utente) session.getAttribute("utente");
if(utente == null) utente = (Utente) session.getAttribute("admin");

Utente utenteToShow = (Utente) request.getAttribute("toShow");
if(utente==null || utenteToShow == null){
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


<div style="background-color: #FF9C08; min-height: 81vh">
<main role="main" class="container">
      <div class="row" > 
       <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body"> 
        <div class="container emp-profile">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img alt="load" src="img/logo.png"	width="100%">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        Gestione Profilo
                                    </h5>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Informazioni</a>
                                </li>
                                 <%if(utente.getEmail().equals(request.getParameter("utente_email"))){%>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Modifica Profilo</a>
                                </li><% }%>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Nome</label>
                                            </div>
                                            <div class="col-md-6">
                                                <a class="col-3"><%=utenteToShow.getNome()%></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Cognome</label>
                                            </div>
                                            <div class="col-md-6">
                                                <a class="col-3"><%=utenteToShow.getCognome()%></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                               <a style="font-size:14px"><%=utenteToShow.getEmail()%></a>
                                            </div>
                                        </div>
                                        <%if(utenteToShow.getTipo().equals("s")){%>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Matricola</label>
                                            </div>
                                            <div class="col-md-6">
                                                <a class="col-3"><%=utenteToShow.getMatricola()%></a>
                                            </div>
                                        </div><% }%>
                                        <%if(utenteToShow.getTipo().equals("d")){%>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Ufficio</label>
                                            </div>
                                            <div class="col-md-6">
                                                <a class="col-3"><%=utenteToShow.getUfficio()%></a>
                                            </div>
                                        </div><% }%>
                                        <div class="row">
                                          <div class="col-md-6">
                                      		    <form method="get" action="modificaPassword.jsp?utente_email="<%=utente.getEmail()%>>
                                                <button type="submit" class="btn btn-primary" name="invio">Cambia Password</button></form>
                                          </div>
                                        </div>
                            </div>
                           
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <form action="ModificaProfiloUtenteServlet" method="post" name="modificaProfilo">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Nome</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="nome" onchange="controlloNome()"placeholder="<%utenteToShow.getNome(); %>">
                                                
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Cognome</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" name="cognome" onchange="controlloCognome()" placeholder=<%utenteToShow.getCognome(); %>>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Data di Nascita</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="date" class="form-control" name="data" onchange="controlloData()" placeholder="Data di Nascita">
                                            </div>
                                        </div>
                                        <%if(utente.getTipo().equals("s")){%>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Matricola</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" name="matricola" onchange="controlloMatricola()"placeholder="Matricola">
                                            </div>
                                        </div><% }%>
                                        <%if(utente.getTipo().equals("d")){%>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Ufficio</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" name="ufficio" onchange="controlloUfficio()" placeholder="Ufficio">
                                            </div>
                                        </div><% }%>
                                    <div id="infoDiv" class="alert alert-danger form-group d-none" role="alert">Attenzione!</div>
									<button type="submit" class="btn btn-primary" name="invio">Salva</button></form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
 		  </div>
 		  </div>
 		  </div>
   <aside class="col-md-4 my-4">
          <div class="p-3 card">
            <h4 class="font-italic">Nome Sezione</h4>
            <ol class="list-unstyled mb-0">
              <li><a href="#">Primo elemento</a></li>
              <li><a href="#">Secondo elemento</a></li>
              <li><a href="#">Terzo elemento</a></li>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/validazioneRegistrazione.js"></script>

</body>
</html>