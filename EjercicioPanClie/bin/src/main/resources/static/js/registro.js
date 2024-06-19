function validar()
{
	
	let g=document.getElementById("correo").value;
	let p=document.getElementById("contrasena").value;
	let n = document.getElementById("nombre").value;
	var email= document.getElementById("correo");
	var validEmail = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/ ;
	
	if (g=="",p=="",n=="" )
	{
		Swal.fire({
  title: " Opps!",
  text: "Alguno o ambos de los campos son nulos!",
  icon: "error"
});
	}
	else{
		if(n.length>3)
		{
			if( validEmail.test(email.value) ){
			
			if(p.length>=5)
			{document.getElementById("agrega").type="submit";
				Swal.fire({
  position: "top-end",
  icon: "success",
  title: "Buen trabajo,datos correctos",
  showConfirmButton: false,
  timer: 1500
});
				
			

			}
			else{Swal.fire({
  title: " Opps!",
  text: "La contraseña  no es valida,tiene que ser mayor de 4 caracteres!",
  icon: "error"
});
			
			}
	
		}else{	Swal.fire({
  title: " Opps!",
  html: `El Email tiene un formato incorrecto,
    <a href="#">ejemplo@gmail.com</a>
  `,
  icon: "error"
});
				return false;
			}
		}
		else{
			Swal.fire({
  title: " Opps!",
  text: "El nombre no es valido, tiene que ser mayor a 3 caracteres!",
  icon: "error"
});
		
		}
	
}
}



function mostrar()
{
	var check= document.getElementById("visible")
	
	if(check.checked)
	{
		$('#contrasena').attr('type', 'text');
	   document.getElementById("ab").style.display = 'block';
	   document.getElementById("ce").style.display = 'none';
		
	}
	else{
		$('#contrasena').attr('type', 'password');
		
       document.getElementById("ab").style.display = 'none';
	   document.getElementById("ce").style.display = 'block';
	}
}

