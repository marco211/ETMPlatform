<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Valuta File</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body ">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Valuta File&nbsp;</h5>
						</div>
						<form
							action="ValutaFileServlet?idTesi=<%=file.getPropostaTesiId()%>
										&nomeFile=<%=file.getNome()%>"
							method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="nome"><b>Voto File:</b></label> <input type="text"
									class="form-control" name="voto" required>
							</div>
							<div class="form-group">
								<label for="descrizione"><b>Descrizione:</b></label>
								<textarea class="form-control" name="descrizione" rows="4"
									required></textarea>
							</div>
							<div class="col text-center">
								<button type="submit" id="valutaFile" name="valutaFile"
									class="btn btn-primary">Valuta</button>
							</div>
						</form>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">

			<div class="p-3 card">
				<h4 class="font-italic">Impostazioni</h4>
				<ol class="list-unstyled mb-0">
					<div class="row" style="border-bottom: 1px solid;"></div>
					<li><a href="#">Scarica file</a></li>
					<li><a
						href="EliminaFileServlet?idTesi=<%=file.getPropostaTesiId()%>
						&nomeFile=<%=file.getNome()%>">Elimina
							file</a></li>
				</ol>
			</div>
			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>