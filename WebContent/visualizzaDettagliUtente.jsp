<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.model.bean.*"%>

<%
Utente utente = (Utente) session.getAttribute("utenteemail");
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Area admin</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">

		<main role="main" class="container">
		<div class="row">
			<div class="col-md-12 my-4">
				<div class="col-md-12 my-4">
					<div class="card mb-3">
						<div class="card-body">
							<div class="container emp-profile">
								<div class="row">
									<div class="col-md-4">
										<div class="profile-img">
											<img alt="load" src="img/logo.png" width="100%">
										</div>
									</div>
									<div class="col-md-6">
										<div class="profile-head">
											<h5>Profilo</h5>
											<ul class="nav nav-tabs" id="myTab" role="tablist">
												<li class="nav-item"><a class="nav-link active"
													id="home-tab" data-toggle="tab" href="#home" role="tab"
													aria-controls="home" aria-selected="true">Informazioni</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-8">
										<div class="tab-content profile-tab" id="myTabContent">
											<div class="tab-pane fade show active" id="home"
												role="tabpanel" aria-labelledby="home-tab">
												<div class="row">
													<div class="col-md-6">
														<label>Nome</label>
													</div>
													<div class="col-md-6">
														<a class="col-3"><%=utente.getNome()%></a>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<label>Cognome</label>
													</div>
													<div class="col-md-6">
														<a class="col-3"><%=utente.getCognome()%></a>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<label>Email</label>
													</div>
													<div class="col-md-6">
														<a style="font-size: 14px"><%=utente.getEmail()%></a>
													</div>
												</div>
												<%if(utente.getTipo().equals("s")){%>
												<div class="row">
													<div class="col-md-6">
														<label>Matricola</label>
													</div>
													<div class="col-md-6">
														<a class="col-3"><%=utente.getMatricola()%></a>
													</div>
												</div>
												<% }%>
												<%if(utente.getTipo().equals("d")){%>
												<div class="row">
													<div class="col-md-6">
														<label>Ufficio</label>
													</div>
													<div class="col-md-6">
														<a class="col-3"><%=utente.getUfficio()%></a>
													</div>
												</div>
												<% }%>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>