<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<section id="cover">
    <div id="cover-caption">
        <div id="container" class="container">
            <div class="row text-black">
                <div class="col-sm-10 offset-sm-1 text-center py-5">
                <img src="https://www.unisa.it/rescue/img/logo_cc.png" class="img-fluid" alt="Responsive image">
                   <p>Per effettuare il recuperdo della password inserisci la mail con la quale ti sei registrato</p>
                    <div class="info-form">
                        <form action="" class="form-inline justify-content-center">
                            <div class="form-group">
                                <label class="sr-only">Email</label>
                                <input type="text" class="form-control" placeholder="mario.rossi@gmail.com">
                            </div>
                        </form>
                    </div>
                    <br>
                  <button type="submit" class="btn btn-success ">Recupera password</button>      
                </div>
            </div>
        </div>
    </div>

</section>
<jsp:include page="footer.jsp" />
</body>
</html>