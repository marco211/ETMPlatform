function controlloNome()
{
	var nome=document.registrazione.nome.value;
	if(nome.length==0)
	{
		document.registrazione.nome.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var cognome=document.registrazione.cognome.value;
	if(cognome.length==0)
	{
		document.registrazione.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.cognome.style.borderColor="green";
		return true;
	}
}

function controlloEmail()
{
	var lettere5=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	var email=document.registrazione.email.value;
	if(!email.match(lettere5))
	{
		document.registrazione.email.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.email.style.borderColor="green";
		return true;
	}
}

function controlloMatricola()
{
	var lettere6=/^[0-9]{10}$/;
	var matricola=document.registrazione.matricola.value;
	if(!matricola.match(lettere6))
	{
		document.registrazione.matricola.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.matricola.style.borderColor="green";
		return true;
	}
}

function controlloInsegnamento()
{
	var insegnamento=document.registrazione.insegnamento.value;
	if(insegnamento.length==0)
	{
		document.registrazione.insegnamento.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.insegnamento.style.borderColor="green";
		return true;
	}
}

function controlloUfficio()
{
	var ufficio=document.registrazione.ufficio.value;
	if(ufficio.length==0)
	{
		document.registrazione.ufficio.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.ufficio.style.borderColor="green";
		return true;
	}
}

function controlloPassword()
{
	var lettere4=/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z]{8,16}$/ //8-16 caratteri(1 cifra,1 lettera mi e ma)
	var password=document.registrazione.password.value;
	if(!password.match(lettere4))
	{
		document.registrazione.password.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.password.style.borderColor="green";
		return true;
	}
}

function controlloData()
{
	var lettere6=/^[0-9]{2}$/;
	var lettere7=/^[0-9]{4}$/;
	var data=document.registrazione.data.value;
	var giorno=data.substring(8,10);
	var mese=data.substring(5,7);
	var anno=data.substring(0,4);
	if(!giorno.match(lettere6))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else if(!mese.match(lettere6))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else if(!anno.match(lettere7))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.data.style.borderColor="green";
		return true;
	}
}


function validazione()
{
	if(!controlloNome())
	{
		document.registrazione.nome.focus();
		return false;
	}
	else if(!controlloCognome())
	{
		document.registrazione.cognome.focus();
		return false;
	}
	else if(!controlloEmail())
	{
		document.registrazione.email.focus();
		return false;
	}
	else
	{
		var tipo=document.registrazione.tipo.value;
		if(tipo=="s")
		{
			if(!controlloMatricola())
			{
				document.registrazione.matricola.focus();
				return false;
			}
		}
		else
		{
			if(!controlloInsegnamento())
			{
				document.registrazione.insegnamento.focus();
				return false;
			}
			else if(!controlloUfficio())
			{
				document.registrazione.ufficio.focus();
				return false;
			}
		}
		if(!controlloPassword())
		{
			document.registrazione.password.focus();
			return false;
		}
		else if(!controlloData())
		{
			document.registrazione.data.focus();
			return false;
		}
		else if(!document.registrazione.check.checked==true)
		{
			document.registrazione.check.focus();
			return false;
		}
		else
		{
			document.registrazione.submit();
		}
	}
}


