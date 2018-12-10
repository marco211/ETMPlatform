<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>
     
     <div class="container" 
     id="page_container">
  <div id="accordion_search_bar_container">
      <input type="search" 
         id="accordion_search_bar" 
         placeholder="Search"/>
  </div>
  <div class="panel-group" 
       id="accordion" 
       role="tablist" 
       aria-multiselectable="true">
    <div class="panel panel-success" 
         id="collapseOne_container">
      <div class="panel-heading" 
           role="tab" 
           id="headingOne">
        <h4 class="panel-title">
          <a role="button" 
             data-toggle="collapse" 
             data-parent="#accordion" 
             href="#collapseOne" 
             aria-expanded="true" 
             aria-controls="collapseOne">
            One
          </a>
        </h4>
      </div>
      <div id="collapseOne" 
           class="panel-collapse collapse in" 
           role="tabpanel" 
           aria-labelledby="headingOne">
        <div class="panel-body">
          <p>Pellentesque convallis dolor</p>
          <p>Enim at tincidunt magna dapibus vitae</p>
        </div>
      </div>
    </div>
    <div class="panel panel-primary" 
         id="collapseTwo_Container">
      <div class="panel-heading" 
           role="tab" 
           id="headingTwo">
        <h4 class="panel-title">
          <a class="collapsed" 
             role="button" 
             data-toggle="collapse" 
             data-parent="#accordion" 
             href="#collapseTwo" 
             aria-expanded="false" 
             aria-controls="collapseTwo">
            Two
          </a>
        </h4>
      </div>
      <div id="collapseTwo" 
           class="panel-collapse collapse in" 
           role="tabpanel" 
           aria-labelledby="headingTwo">
        <div class="panel-body">
          <p>Vestibulum in laoreet nisi</p>
          <p>Sit amet placerat massa</p>
        </div>
      </div>
    </div>
    <div class="panel panel-danger" 
         id="collapseThree_Container">
      <div class="panel-heading" 
           role="tab" 
           id="headingThree">
        <h4 class="panel-title">
          <a class="collapsed" 
             role="button" 
             data-toggle="collapse" 
             data-parent="#accordion" 
             href="#collapseThree" 
             aria-expanded="false" 
             aria-controls="collapseThree">
            Three
          </a>
        </h4>
      </div>
      <div id="collapseThree" 
           class="panel-collapse collapse in" 
           role="tabpanel" 
           aria-labelledby="headingThree">
        <div class="panel-body">
          <p>Curabitur sem eros tempor sit</p>
          <p>Amet nunc eget, gravida mollis</p>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>