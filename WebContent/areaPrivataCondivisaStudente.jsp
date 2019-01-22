<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.unisa.etm.model.bean.*,java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	if(utente.getTipo().equals("d")){
		response.sendRedirect("./areaPrivataCondivisaDocente.jsp");
		return;
	}
	PropostaTesi tesi = (PropostaTesi) session.getAttribute("propostaTesi");
	@SuppressWarnings("unchecked")
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	@SuppressWarnings("unchecked")
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Area privata condivisa</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
	 cambiaColore();
	});

function cambiaColore(){
	document.getElementById("areaCondivisa").className = "nav-link text-primary";
};
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body" style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<%if(utente.getPropostaTesi_Id()>0){ %>
							<form action="VisualizzaDettagliTesiServlet" method="get">
								<input type="hidden" name="propostatesi_id"
									value="<%=utente.getPropostaTesi_Id() %>">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="infoTesi">
									<i class="fa fa-info-circle" aria-hidden="true"></i>
								</button>
							</form>

							<form action="VisualizzaStoricoServlet" method="get">
								<input type="hidden" name="propostaTesiId"
									value="<%=utente.getPropostaTesi_Id()%>">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="VisualizzaArchivio">
									<span class="fa fa-archive"></span>
								</button>
							</form>

							<form action="caricaFile.jsp">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="AddFile">
									<i class="fas fa-plus-circle"></i>
								</button>
							</form>
							<%} %>
						</div>


						<table class="table table-striped">
							<%
								if (file != null) {
							%>
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">File</th>
									<th scope="col">Email Utente</th>
									<th scope="col">Valutazione</th>
								</tr>
							</thead>
							<%
									for (int i = 0; i < file.size(); i++) {
							%>
							<tbody>
								<tr>
									<th scope="row"><i class="fa fa-file fa"
										aria-hidden="true"></i></th>
									<td><a
										href="VisualizzaInfoFileServlet?nomeFile=<%=file.get(i).getNome()%>&idTesi=<%=file.get(i).getPropostaTesiId()%>">
											<%=file.get(i).getNome()%>
									</a></td>
									<td><%=file.get(i).getEmail()%></td>
									<%if(file.get(i).getVoto()!=0) {%>
									<td><%=file.get(i).getVoto()%></td>
									<%} else if(file.get(i).getVoto()==0){%>
									<td>Non valutato</td>
									<%} %>
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


			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 35vh;">
				<h4 class="font-italic"><%= tesi.getTitolo() %></h4>
				<h6><%= tesi.getDecrizione() %></h6>
			</div>

			<div class="p-3 card my-4" style="min-height: 35vh;">
				<h4 class="font-italic">To Do List</h4>
				<%
					if (consegne != null) {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">N° Consegna</th>
							<th scope="col">Nome</th>
						</tr>
					</thead>
					<%
						for (int i = 0; i < consegne.size(); i++) {
					%>
					<tbody>
						<tr>
							<th><a><%=i + 1%></a></th>
							<th><a
								href="VisualizzaInfoConsegnaServlet?idConsegna=<%=consegne.get(i).getId()%>"><%=consegne.get(i).getNome()%></a></th>
						</tr>

					</tbody>
					<%
						}
					%>
				</table>
				<%
						}
					%>

			</div>

			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>
