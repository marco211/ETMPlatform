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
<title>Modifica Password Utente</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

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
                                <input type="text" name="newpass" class="form-control" placeholder="Nuova Password"> 
                                <input type="text" name="newpass" class="form-control" placeholder="Conferma Password"> 
                                 
                            </div>
                        </form>
                   </div>
                    <br>
                  <button type="submit" class="btn btn-success ">Modifica password</button>      
                
                </div>
            </div>
        </div>
    </div>

</section>
<jsp:include page="footer.jsp" />
</body>
</html>