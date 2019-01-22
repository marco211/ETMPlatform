<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.model.bean.*,java.util.*"%>

<%
Utente utente =(Utente)session.getAttribute("utente");
if(utente == null || !(utente.getTipo().equals("a"))){
	
	response.sendRedirect("./index.jsp");
    return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Home</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
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
							<h5 class="text-info">Lista utenti&nbsp;</h5>
							<input class="form-control form-control-sm mr-2 w-50" type="text"
								placeholder="Cerca utente" aria-label="Cerca utente">
							<button type="button"
								class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
								id="CercaProposta">
								<span class="fa fa-search"></span>
							</button>
							<button type="button"
								class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
								id="AddProposta">
								<i class="fas fa-plus-circle"></i>
							</button>
							<select class="form-control form-group"
								id="inlineFormCustomSelectPref">
								<option selected>Scegli</option>
								<option value="1">Uno</option>
								<option value="2">Due</option>
								<option value="3">Tre</option>
							</select>

						</form>

						<ol class="list-unstyled mb-0">
							<li><a href="#">PincoPallinoJoe</a></li>
						</ol>
					</div>
				</div>

			</div>

			<aside class="col-md-4 my-4">

			<div class="p-3 card">
				<h4 class="font-italic">Info sull'utente</h4>
				<ol class="list-unstyled mb-0">
					<li><a href="#">Primo elemento</a></li>
				</ol>
			</div>

			</aside>

		</div>

		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>