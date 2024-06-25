$(document).ready(function(){
	
	const showButton = document.querySelectorAll(".showButton");
		for(let i = 0; showButton.length; i++){
			 showButton[i].addEventListener("click", function(){
			 const alertDialog = document.querySelector("#dialog");
	        alertDialog.showModal();
	        const inputId = showButton[i].id;
	        let nuevaFuente = "";
	        let precio = "";
	        
	         // Determinar la nueva fuente de la imagen según el input presionado
            switch (inputId) {
                case "puerquito":
                    nuevaFuente = "imajes/puerquito.jpg";
                    precio =5;
                    break;
                case "concha":
                    nuevaFuente = "imajes/concha.jpg";
                     precio =5;
                    break;
                case "dona":
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
            cambiarImagen(inputId, nuevaFuente, precio);
});
		}
   


});


function cambiarImagen(inputId, nuevaFuente , precio) {
    const imagenDialog = document.querySelector("#imgP");
    imagenDialog.src = nuevaFuente;
    document.getElementById("tipo_de_pan").value = inputId;
       
      calcularMonto();
}



     function calcularMonto() {
  		var cantidad = parseFloat(document.getElementById("cantidad").value);
  		
		var producto = document.getElementById("tipo_de_pan").value.toLowerCase();
    
    // Definir los precios de los productos
    var precios = {
        "puerquito": 5,
        "concha": 5,
        "dona": 7,
        "mantecada": 7,
        "oreja": 7,
        "yoyo": 7,
        "bolillo": 2,
        "cuernito": 5, 
        "baguette": 10
    };

	 if (precios[producto] === undefined || cantidad <= 0) {

                 Swal.fire("Tipo de pan no reconocido o cantidad inválida.");

                return;

            }


   if (precios.hasOwnProperty(producto)) {
        // Calcular el costo multiplicando el precio por la cantidad
        var costo = cantidad * precios[producto];
              
        // Actualizar el valor del input de costo
        document.getElementById("costo").value = costo;
        localStorage.setItem("costo",costo);
          localStorage.setItem("cantidad",cantidad);
            localStorage.setItem("tipo_de_pan",producto);
    } else {
        // Si el producto no está en la lista de precios, mostrar un mensaje de error o manejarlo según sea necesario
        console.error("El producto seleccionado no tiene un precio definido.");
    }
    
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
function ventaP() {
  
   document.getElementById("tipo_de_panIn").value = localStorage.getItem("producto");
   document.getElementById("costoIn").value =  localStorage.getItem("costo");
   document.getElementById("cantidadIn").value = localStorage.getItem("cantidad");
    //window.location.href = "formi"; 
}
 function setFechaActual() {
            const now = new Date();
            const year = now.getFullYear();
            const month = String(now.getMonth() + 1).padStart(2, '0');
            const day = String(now.getDate()).padStart(2, '0');
            document.getElementById('pedido').value = `${year}-${month}-${day}`;
        }
 