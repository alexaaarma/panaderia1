package com.mx.cbtis.modelo;

public class Venta{
	private Integer id;
	private String cajero;
	private String  tipo_de_pan;
	private Integer cantidad;
	private Integer monto;
	private Integer anticipo;
	private Integer cambio;
	public Venta() {
		super();
	}
	public Venta(Integer id, String cajero, String tipo_de_pan, Integer cantidad, Integer monto, Integer anticipo,
			Integer cambio) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.tipo_de_pan = tipo_de_pan;
		this.cantidad = cantidad;
		this.monto = monto;
		this.anticipo = anticipo;
		this.cambio = cambio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCajero() {
		return cajero;
	}
	public void setCajero(String cajero) {
		this.cajero = cajero;
	}
	public String getTipo_de_pan() {
		return tipo_de_pan;
	}
	public void setTipo_de_pan(String tipo_de_pan) {
		this.tipo_de_pan = tipo_de_pan;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public Integer getAnticipo() {
		return anticipo;
	}
	public void setAnticipo(Integer anticipo) {
		this.anticipo = anticipo;
	}
	public Integer getCambio() {
		return cambio;
	}
	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}
}