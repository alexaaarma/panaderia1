package com.mx.cbtis.modelo;

public class Producto {

	private Integer id;
	private String nombrePan;
	private Integer cantidad;
	private Integer costo;
	
	public Producto() {
		super();
	}
	
	public Producto(Integer id, String nombrePan, Integer cantidad, Integer costo){
		super();
		this.id = id;
		this.nombrePan = nombrePan;
		this.cantidad = cantidad;
		this.costo = costo;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrePan() {
		return nombrePan;
	}

	public void setNombrePan(String nombrePan) {
		this.nombrePan = nombrePan;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	

}
