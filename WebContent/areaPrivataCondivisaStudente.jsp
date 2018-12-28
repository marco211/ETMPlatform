<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Area privata condivisa</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08; min-height: 81vh;">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body" style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<%if(utente.getPropostaTesi_ID()>0){ %>
							<form action="VisualizzaDettagliTesiServlet" method="get">
								<input type="hidden" name="propostatesi_id" value="<%=utente.getPropostaTesi_ID() %>">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="infoTesi">
									<i class="fa fa-info-circle" aria-hidden="true"></i>
								</button>
							</form>
							
							<form action="VisualizzaStoricoServlet" method="get">
								<input type="hidden" name="propostaTesiId" value="<%=utente.getPropostaTesi_ID()%>">
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

						
						<div class="list-group">
							<%
								if (file != null) {
									for (int i = 0; i < file.size(); i++) {
							%>
							<a class="list-group-item"
								href="VisualizzaInfoFileServlet?nomeFile=<%=file.get(i).getNome()%>&idTesi=<%=file.get(i).getPropostaTesiId()%>"><i
								 class="fa fa-file fa-2x" aria-hidden="true"></i>&nbsp; <%=file.get(i).getNome()%></a>
							<%
								}
								}
							%>
						</div>
						
					</div>
				</div>

			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card" style="min-height: 80vh;">

				<h4 class="font-italic">To Do List</h4>
				<ul class="list-group list-group-flush">
					<%
						if (consegne != null) {
							for (int i = 0; i < consegne.size(); i++) {
					%>
					<li class="list-group-item"><a href="#"> <%=
								consegne.get(i).getNome()
							%>
					</a></li>
					<%
						}
						}
					%>
				</ul>
			</div>
			</aside>
		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>
