$(document).ready(function(){
	
	const showButton = document.querySelectorAll(".showButton");
		for(let i = 0; showButton.length; i++){
			 showButton[i].addEventListener("click", function(){
			 const alertDialog = document.querySelector("#dialog");
	        alertDialog.showModal();
	        const inputId = showButton[i].id
	        let nuevaFuente = "";
	        let precio = ""
	         // Determinar la nueva fuente de la imagen según el input presionado
            switch (inputId) {
                case "Puerquito":
                    nuevaFuente = "imajes/puerquito.jpg";
                    precio =5;
                    break;
                case "Concha":
                    nuevaFuente = "imajes/concha.jpg";
                     precio =5;
                    break;
                case "Dona":
                    nuevaFuente = "imajes/donas.jpg";
                     precio =7;
                    break;
                    case "mantecada":
                    nuevaFuente = "imajes/mantecadas.jpg";
                     precio =7;
                    break;
                    case "oreja":
                    nuevaFuente = "imajes/orejas.jpg";
                     precio =7;
                    break;
                    case "yoyo":
                    nuevaFuente = "imajes/yoyos.jpg";
                     precio =7;
                    break;
                     case "bolillo":
                    nuevaFuente = "imajes/bolillo.png";
                     precio =2;
                    break;
                    case "cuernito":
                    nuevaFuente = "imajes/cuernito.jpg";
                     precio =10;
                    break;
                     case "baguette":
                    nuevaFuente = "imajes/baguette.jpg";
                     precio =5;
                    break;
                // Agregar más casos para otros inputs si es necesario
                default:
                    nuevaFuente = ""; // Asigna una fuente por defecto si no se encuentra el input
                    break;
            }

            // Llamar a la función para cambiar la imagen
            cambiarImagen(inputId, nuevaFuente);
});
		}
   


});


function cambiarImagen(inputId, nuevaFuente) {
    const imagenDialog = document.querySelector("#imgP");
    imagenDialog.src = nuevaFuente;
    
}

function eliminarPedidos(idPedidos){
	
	$.ajax({
		url : "/eliminarPedidos",
		contentType:"application/json",
		data :JSON.stringify({id:idPedidos}),
		type : "POST",
		success:function(){window.location.href = "pedidos"}
			
	});
	
}

     function calcularMonto() {

            const precios = {
                "puerquito": 5,
                "concha": 5,
                "donas": 7,
                "mantecadas": 7,
                "orejas": 7,
                "yoyo": 7,
                "bolillo": 2,
                "baguette": 10,
                "cuernito": 5
            };
            let tipoDePan = document.getElementById('tipo_de_pan').value.toLowerCase();
            let cantidad = document.getElementById('cantidad').value;
            let anticipo = document.getElementById('anticipo').value;
            if (precios[tipoDePan] === undefined || cantidad <= 0) {
                alert("Tipo de pan no reconocido o cantidad inválida.");
                return;
            }
            let total = precios[tipoDePan] * cantidad;
            document.getElementById('costo').value = total;
            let cambio = 0;
            if (anticipo !== "") {
                cambio = anticipo - total;
                document.getElementById('cambio').value = cambio >= 0 ? cambio : 0;
            }
            // Display the results in the dialog
            document.getElementById('costo').textContent = `Monto Total: $${total}`;
            document.getElementById('change-amount').textContent = `Cambio: $${cambio >= 0 ? cambio : 0}`;
            document.getElementById('dialog').style.display = 'block';
            document.getElementById('dialog-overlay').style.display = 'block';
        }
        function closeDialog() {
            document.getElementById('dialog').style.display = 'none';
            document.getElementById('dialog-overlay').style.display = 'none';

        }

 