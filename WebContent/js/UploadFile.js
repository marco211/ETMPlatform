function carica(c){
	if(c==false){
		document.getElementById("uploadFile").className = "d-block";
		document.getElementById("inviaFile").className = "btn bg-warning d-block";
		return true;
	}
	else{
		document.getElementById("uploadFile").className = "d-none";
		document.getElementById("inviaFile").className = "d-none";
		return false;
	}
}
