function controlloPassword(){
var lettere4=/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z]{8,16}$/ //8-16 caratteri(1 cifra,1 lettera mi e ma)
	var password=document.modificaPassword.password.value;
	if(!password.match(lettere4))
	{
		document.modificaPassword.password.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaPassword.password.style.borderColor="green";
		return true;
	}
}


function controlloPassword2(){
	var lettere4=/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z]{8,16}$/ //8-16 caratteri(1 cifra,1 lettera mi e ma)
		var password=document.modificaPassword.password2.value;
		if(!password.match(lettere4))
		{
			document.modificaPassword.password2.style.borderColor="red";
			return false;
		}
		else
		{
			document.modificaPassword.password2.style.borderColor="green";
			return true;
		}
	}


function validazione(){
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var div = $("#infoDiv");
	div.text("");
	if(!controlloPassword()){
		div.append("La password deve essere compresa tra 8 e 16 caratteri, deve contenere una lettera Maiuscola, una lettera minuscola e un numero.");
		return false;
	}
	if(!controlloPassword2()){
		div.append("La password deve essere compresa tra 8 e 16 caratteri, deve contenere una lettera Maiuscola, una lettera minuscola e un numero.");
		return false;
	}
	var password=document.modificaPassword.password2.value;
	var password1=document.modificaPassword.password.value;
	if(password===password1){
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
		return true;
	}
	else{
		div.append("Le password devono essere uguali.");
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
		return false;
}
	
}



