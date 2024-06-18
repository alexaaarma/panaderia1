package com.mx.cbtis.modelo;
 



public class Asistencia {

	
	private Integer id;
	private String fecha;
	private String hora_llegada;
	private String salida;
	private String cargo;
	private String nombre;
	public Asistencia() {
		super();
	}
	public Asistencia(Integer id, String fecha, String hora_llegada, String salida, String cargo, String nombre) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora_llegada = hora_llegada;
		this.salida = salida;
		this.cargo = cargo;
		this.nombre = nombre;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}