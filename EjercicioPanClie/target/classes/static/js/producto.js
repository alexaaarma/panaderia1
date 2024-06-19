$(document).ready(function(){
	
});
function eliminarProducto(idProducto){
	$.ajax({
		url:"/eliminarProducto",
		contentType:"application/json",
		data: JSON.stringify({id:idProducto}),
		type: "POST",
		success: function(){
			window.location.href = 'producto';
		}

	});
}

function actualizarProducto(idProducto){
	$.ajax({
		url:"/actualizarProducto",
		contentType:"application/json",
		data: JSON.stringify({id:idProducto}),
		type: "GET",
		success: function(){
			window.location.href = 'producto';
		}

	});
}