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
	if(!controlloPassword()){
		return false;
	}
	if(!controlloPassword2()){
	return false;
	}
	var password=document.modificaPassword.password2.value;
	var password1=document.modificaPassword.password.value;
	if(password===password1){
		return true;
	}
	else{
		return false;
}
	
}



