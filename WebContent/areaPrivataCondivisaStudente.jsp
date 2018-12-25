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
	//File f = new File("Primo", 1, "eurofilo", 5,"", "f@unisa.it");
	//ArrayList<File> file = new ArrayList<File>();
	//file.add(f);
	ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
	ArrayList<Consegna> consegne = (ArrayList<Consegna>) session.getAttribute("listaConsegne");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Privata Condivisa</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<form action="VisualizzaStoricoServlet" method="get">
								<input type="hidden" name="propostaTesiId" value="<%=utente.getPropostaTesi_ID()%>">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="VisualizzaArchivio">
									<span class="fa fa-archive"></span>
								</button>
							</form>
							<%if(utente.getPropostaTesi_ID()>0){ %>
							<form action="caricaFile.jsp">
								<button type="submit"
									class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
									id="AddFile">
									<i class="fas fa-plus-circle"></i>
								</button>
							</form>
							<%} %>
						</div>



						<ul class="list-group list-group-flush">
							<%
								if (file != null) {
									for (int i = 0; i < file.size(); i++) {
							%>
							<li class="list-group-item"><a href="VisualizzaInfoFileServlet?idTesi=<%=file.get(i).getPropostaTesiId()%>&nomeFile=<%=file.get(i).getNome()%>"> <%=
										file.get(i).getNome()
									%>
							</a></li>
							<%
								}
								}
							%>
						</ul>
						
					</div>
				</div>

			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card">

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
