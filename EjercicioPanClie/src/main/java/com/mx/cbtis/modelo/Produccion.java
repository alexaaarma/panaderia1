package com.mx.cbtis.modelo;



public class Produccion {
	
	private Integer id;
	private Integer cantidad;
	private String fecha;
	private String caducidad;
	private String nombre_materia;
	
	public Produccion(Integer id, Integer cantidad, String fecha, String caducidad, String nombre_materia) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.caducidad = caducidad;
		this.nombre_materia = nombre_materia;
	}

	public Produccion() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public String getNombre_materia() {
		return nombre_materia;
	}

	public void setNombre_materia(String nombre_materia) {
		this.nombre_materia = nombre_materia;
	}
	

	
	

}
