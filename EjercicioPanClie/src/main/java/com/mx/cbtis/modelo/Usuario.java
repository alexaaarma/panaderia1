package com.mx.cbtis.modelo;





public class Usuario {


	private Integer id; 
	
	private String correo ;
	
	private String contrasena ;
	
	private String nombre;
	
	

	
	

	public Usuario() {
		super();
	}






	public Usuario(Integer id, String correo, String contrasena, String nombre) {
		super();
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
	}






	public Integer getId() {
		return id;
	}






	public void setId(Integer id) {
		this.id = id;
	}






	public String getCorreo() {
		return correo;
	}






	public void setCorreo(String correo) {
		this.correo = correo;
	}






	public String getContrasena() {
		return contrasena;
	}






	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

	


	