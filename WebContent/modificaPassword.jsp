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
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Modifica password</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>
<section id="cover">
    <div id="cover-caption">
        <div id="container" class="container">
            <div class="row text-black">
                <div class="col-sm-10 offset-sm-1 text-center py-5">
                <img src="https://www.unisa.it/rescue/img/logo_cc.png" class="img-fluid" alt="Responsive image">
                   <p>Inserisci due volte la nuova password per apportare la modifica.</p>
                    <div class="info-form">
                        <form action="ModificaPasswordServlet" method="post" class="form-inline justify-content-center">
                            <div class="form-group">
                                <label class="sr-only">Nuova Password</label>
                                <input type="password" name="password1" class="form-control" placeholder="Nuova Password"> 
                                <input type="password" name="password2" class="form-control" placeholder="Conferma Password"> 
                                 
                            </div>
                       
                   </div>
                    <br>
                  <button type="submit" class="btn btn-success ">Modifica password</button></form>     
                
                </div>
            </div>
        </div>
    </div>

</section>
<jsp:include page="footer.jsp" />
</body>
</html>