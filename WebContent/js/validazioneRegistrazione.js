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
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	
	if(!controlloNome()){
		
		document.registrazione.nome.focus();
		div.append("Inserisci un nome");
	}
	else if(!controlloCognome())
	{
		if(!focused){
			document.registrazione.cognome.focus();
			focused = true;
		}
		div.append("Problema con il cognome!");
	}
	else if(!controlloEmail())
	{
		if(!focused){
			document.registrazione.email.focus();
			focused = true;
		}
		
		div.append("Problema con il cognome!");
	}
	else
	{
		var tipo=document.registrazione.tipo.value;
		if(tipo=="s")
		{
			if(!controlloMatricola())
			{
				if(!focused){
					document.registrazione.matricola.focus();
					focused = true;
				}
			}
		}
		else
		{
			if(!controlloInsegnamento())
			{
				if(!focused){
					document.registrazione.insegnamento.focus();
					focused = true;
				}
			}
			else if(!controlloUfficio())
			{
				if(!focused){
					document.registrazione.ufficio.focus();
					focused = true;
				}
			}
		}
		if(!controlloPassword())
		{
			if(!focused){
				document.registrazione.password.focus();
				focused = true;
			}
		}
		else if(!controlloData())
		{
			if(!focused){
				document.registrazione.data.focus();
				focused = true;
			}
		}
		else if(!document.registrazione.check.checked==true)
		{
			if(!focused){
				document.registrazione.check.focus();
				focused = true;
			}
		}
		else
		{
			document.registrazione.submit();
		}
	}
}


