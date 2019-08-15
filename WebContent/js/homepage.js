$(document).ready(function(){
	cambiaColore();
	getTesiRecenti();
});

function cambiaColore(){
	document.getElementById("home").className = "nav-link text-primary";
};

function getTesiRecenti(){
	var request=new XMLHttpRequest();
	var url="TesiRecentiServlet";
	request.onreadystatechange=function(){
		if(request.readyState==4){
			var val=request.responseText;
			$("#recenti").html(val);
		}
	}

	request.open("GET",url,true);
	request.send(null);
};

