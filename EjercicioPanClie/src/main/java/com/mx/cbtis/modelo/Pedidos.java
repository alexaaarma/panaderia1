package com.mx.cbtis.modelo;




public class Pedidos {
	
	
	private Integer id;
	private String nombre;
	private String dia_pedido;
	private String dia_entrega;
	private String direccion;
	private Integer cantidad;
	private String tipo_pan;
	private Integer costo;
	private Integer anticipo;
	public Pedidos(Integer id, String nombre, String dia_pedido, String dia_entrega, String direccion, Integer cantidad,
			String tipo_pan, Integer costo, Integer anticipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dia_pedido = dia_pedido;
		this.dia_entrega = dia_entrega;
		this.direccion = direccion;
		this.cantidad = cantidad;
		this.tipo_pan = tipo_pan;
		this.costo = costo;
		this.anticipo = anticipo;
	}

	public Pedidos() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia_pedido() {
		return dia_pedido;
	}

	public void setDia_pedido(String dia_pedido) {
		this.dia_pedido = dia_pedido;
	}

	public String getDia_entrega() {
		return dia_entrega;
	}

	public void setDia_entrega(String dia_entrega) {
		this.dia_entrega = dia_entrega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo_pan() {
		return tipo_pan;
	}

	public void setTipo_pan(String tipo_pan) {
		this.tipo_pan = tipo_pan;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getAnticipo() {
		return anticipo;
	}

	public void setAnticipo(Integer anticipo) {
		this.anticipo = anticipo;
	}
	
	
}
