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
  				
 			
   			 <h5 class="card-title">Proposte tesi</h5>
    		 <ol class="list-unstyled mb-0">
              <li><a href="#">Proposta tesi 1</a></li>
              <li><a href="#">Proposta tesi 2</a></li>
              <li><a href="#">Proposta tesi 3</a></li>
            </ol>
 		    </div>
</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Nome sezione</h4>
            <ol class="list-unstyled mb-0">
              <li><a href="#">Primo elemento</a></li>
              <li><a href="#">Secondo elemento</a></li>
              <li><a href="#">Terzo elemento</a></li>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>