/**
 * 
 */

$(document).ready(function() {
	document.getElementById("profilo").className = "nav-link text-primary";
});


function seguiUtente(follower, toFollow){
	var addProp;
	var changeProp;
	var disProp;

	if($('#addprop').is(':checked')){
		addProp = true;
	} else {
		addProp = false;
	}
	if($('#changeprop').is(':checked')){
		changeProp = true;
	} else {
		changeProp = false;
	}
	if($('#disprop').is(':checked')){
		disProp = true;
	} else{
		disProp = false;
	}

	var url = 'SeguiUtenteServlet?follower=' + follower + '&toFollow=' + toFollow + '&addprop=' + addProp + '&changeprop=' + changeProp + '&disprop=' + disProp;
	
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.onreadystatechange = function() { 
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)

			window.location.reload(false);
	}
	xmlHttp.open("GET", url, true); // true for asynchronous 
	xmlHttp.send(null);

}


function seguiTutto(follower, toFollow){
	var url = 'SeguiUtenteServlet?follower=' + follower + '&toFollow=' + toFollow + '&addprop=true&changeprop=true&disprop=true';
	
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.onreadystatechange = function() { 
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)

			window.location.reload(false);
	}
	xmlHttp.open("GET", url, true); // true for asynchronous 
	xmlHttp.send(null);
}

function nonSeguire(follower, toFollow){
	var url = 'SeguiUtenteServlet?tipoop=delete&follower=' + follower + '&toFollow=' + toFollow;
	
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.onreadystatechange = function() { 
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)

			window.location.reload(false);
	}
	xmlHttp.open("GET", url, true); // true for asynchronous 
	xmlHttp.send(null);
}