<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.unisa.etm.model.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	File file = (File) session.getAttribute("infoFile");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Valuta file</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body " style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Valuta File&nbsp;</h5>
						</div>
						<form action="ValutaFileServlet" method="post" name="valuta">
							<input type="hidden" name="idTesi"
								value="<%=file.getPropostaTesiId()%>"> <input
								type="hidden" name="nomeFile" value="<%=file.getNome()%>">
							<div class="form-group">
								<label for="voto"><b>Voto File:</b></label> <input type="number"
									min="0" max="5" class="form-control" name="voto"
									onchange="controlloVoto()" required>
							</div>
							<div class="form-group">
								<label for="descrizione"><b>Descrizione:</b></label>
								<textarea class="form-control" name="descrizione" rows="4"
									onchange="controlloDescrizione()" required></textarea>
							</div>
							<div class="col text-center">
								<div id="infoDiv" class="alert alert-danger form-group d-none"
									role="alert"></div>
								<button type="submit" id="valutaFile" name="valutaFile"
									class="btn btn-primary" onclick="return validazione()">Valuta</button>
							</div>
						</form>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">

			<div class="p-3 card" style="min-height: 80vh;">
				<h4 class="font-italic">Impostazioni</h4>
				<ol class="list-unstyled mb-0">
					<div class="row" style="border-bottom: 1px solid;"></div>
					<li><a
						href="ScaricaFileServlet?nomeFile=<%=file.getNome()%>&tesiID=<%=file.getPropostaTesiId()%>">Scarica
							file</a></li>
					<li><a
						href="EliminaFileServlet?idTesi=<%=file.getPropostaTesiId()%>&nomeFile=<%=file.getNome()%>">Elimina
							file</a></li>
				</ol>
			</div>
			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />

	<script src="js/valutaFile.js"></script>
</body>
</html>