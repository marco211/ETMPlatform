<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.unisa.etm.model.bean.*,java.util.*"%>

<%
	@SuppressWarnings("unchecked")
	ArrayList<Utente> utenti = (ArrayList<Utente>) request.getAttribute("listaUtenti");
	if (utenti == null) {
		response.sendRedirect("./homePage.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform</title>
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
				<div class="card mb-3">
					<div class="card-body" style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Utenti&nbsp;</h5>
							<%
								if (utenti != null) {
							%>
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">Nome</th>
										<th scope="col">Cognome</th>
										<th scope="col">Email</th>
										<th scope="col">M/U</th>
										<th scope="col">#</th>
									</tr>
								</thead>
								<%		
									for (int i = 0; i < utenti.size(); i++) {
							%>
								<tbody>
									<tr>
										<td><%=utenti.get(i).getNome()%></td>
										<td><%=utenti.get(i).getCognome()%></td>
										<td><%=utenti.get(i).getEmail() %></td>
										<%if(utenti.get(i).getTipo().equals("s")){ %>
										<td><%=utenti.get(i).getMatricola()%></td>
										<%} else if(utenti.get(i).getTipo().equals("d")){%>
										<td><%=utenti.get(i).getUfficio()%></td>
										<%} %>
										<td><a
											href="VisualizzaProfiloUtenteServlet?utente_email=<%=utenti.get(i).getEmail()%>">visualizza</a>
										</td>
									</tr>

								</tbody>
								<%
								}
								}
							%>
							</table>
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