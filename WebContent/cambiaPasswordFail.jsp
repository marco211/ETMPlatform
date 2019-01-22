<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.user.*,it.unisa.etm.model.bean.*, java.time.* "%>
<%
	Amministratore admin = (Amministratore) session.getAttribute("admin");
	Utente utente = (Utente) session.getAttribute("utente");
	if(utente==null && admin == null){
		response.sendRedirect("./index.jsp");
	    return;
	}
	ArrayList<Partecipa> partecipazioni = (ArrayList<Partecipa>) session.getAttribute("listaPartecipazione");
	if(partecipazioni == null)
		partecipazioni = new ArrayList<>();
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - TesiError</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<section id="cover">
			<div id="cover-caption">
				<div id="container" class="container">
					<div class="row text-black">
						<div class="col-sm-10 offset-sm-1 text-center py-5">
							<img src="https://www.unisa.it/rescue/img/logo_cc.png"
								class="img-fluid" alt="Responsive image">
							<p>Problemi con la modifica della password</p>

							<form action="VisualizzaProfiloUtenteServlet" method="post"
								class="d-none d-lg-block d-xl-block">
								<input type="hidden" name="utente_email"
									value="<%=utente.getEmail()%>">


								<button type="submit" class="btn btn-success ">Torna al
									profilo utente</button>
							</form>
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>