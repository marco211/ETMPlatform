<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AreaFile</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"/>


<div style="background-color: #FF9C08">
<main role="main" class="container">
      <div class="row" >  
        <div class="col-md-8 my-4">
        <div class="card mb-3">
        	<div class="card-body">
  				
 			
   			 <h5 class="card-title" style="color:#3385ff">File 1</h5>
   			 	<div class="row" style="border-bottom: 1px solid;"></div>
    		 		Informazioni del file...
    		 		
    		 		
 			</div>
		</div>
         
        </div>

        <aside class="col-md-4 my-4">

          <div class="p-3 card">
            <h4 class="font-italic">Impostazioni</h4>
            <ol class="list-unstyled mb-0">
            <div class="row" style="border-bottom: 1px solid;"></div>
              <li><a href="#">Scarica file</a></li>
              <li><a href="#">Valiuta file</a></li>
              <li><a href="#">Elimina file</a></li>
            </ol>
          </div>
   
        </aside>

      </div>

    </main>
</div>
    
<jsp:include page="footer.jsp" />

</body>
</html>