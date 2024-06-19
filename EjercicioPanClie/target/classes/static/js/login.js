

function validar()
{
	let g=document.getElementById("email").value;
	let p=document.getElementById("password").value;
	var email= document.getElementById("email");
	var validEmail = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/ ;
	
	if (g=="",p=="" )
	{
		Swal.fire({
  title: " Opps!",
  text: "Alguno o ambos de los campos son nulos!",
  icon: "error"
});
		}
	else{
		if( validEmail.test(email.value) ){
				$.ajax({
						url:"verificarLogin",
						contentType:"application/json",
						data: JSON.stringify({
						correo:$("#email").val(),
						contrasena:$("#password").val()
			
						}),
						type:"POST",
						success:function(data){
								console.log(data);
								if(data.nombre==='000'){
									Swal.fire({
  title: " Opps!",
  text: "El usuario o contraseña es incorrecto!",
  icon: "error"
});
								}else{
									window.location.href='menu';
								}
						}
					});
	
		}else{Swal.fire({
  title: " Opps!",
  html: `El gmail tiene un formato incorrecto,
    <a href="#">ejemplo@gmail.com</a>
  `,
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
		$('#password').attr('type', 'text');
	   document.getElementById("ab").style.display = 'block';
	   document.getElementById("ce").style.display = 'none';
		
	}
	else{
		$('#password').attr('type', 'password');
		
       document.getElementById("ab").style.display = 'none';
	   document.getElementById("ce").style.display = 'block';
	}
}


