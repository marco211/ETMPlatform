<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div style="background-color: #FF9C08">
<main role="main" class="container">
      <div class="row">  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        <div class="card-body">
  				
 			
   			 <h5 class="card-title" style="border-bottom: 1px solid">Descrizione proposta tesi</h5>
    		 <ol class="list-unstyled mb-0">
              <li><a href="#">Lorem ipsum dolor mammt </a></li>
            </ol>
 		    </div>
</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Lista proposte tesi</h4>
             <div class="list-group">
  				<button type="button" class="list-group-item list-group-item-action active">Cras justo odio</button>
  				<button type="button" class="list-group-item list-group-item-action">Dapibus ac facilisis in</button>
  				<button type="button" class="list-group-item list-group-item-action">Morbi leo risus</button>
  				<button type="button" class="list-group-item list-group-item-action">Porta ac consectetur ac</button>
  				<button type="button" class="list-group-item list-group-item-action" disabled>Vestibulum at eros</button>
			</div>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>