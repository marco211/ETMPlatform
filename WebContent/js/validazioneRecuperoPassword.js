function controlloEmail()
{
	var lettere5=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	var email=document.recupero_password.email.value;
	if(!email.match(lettere5))
	{
		document.recupero_password.email.style.borderColor="red";
		return false;
	}
	else
	{
		document.recupero_password.email.style.borderColor="green";
		return true;
	}
}


function validazione()
{
	if(!controlloEmail())
	{
		document.recupero_password.email.focus();
		return false;
	}
	else
	{
			document.recupero_password.submit();
	}
}
