package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombreLibro;
	private String precioLibro;
	private String nombreCliente;
	
	public Venta() {
		super();
	}
	
	public Venta(Long id, String nombreLibro, String precioLibro, String nombreCliente) {
		super();
		this.id = id;
		this.nombreLibro = nombreLibro;
		this.precioLibro = precioLibro;
		this.nombreCliente = nombreCliente;
	}
	
	@Override
	public String toString() {
		return "Venta [id=" + id + ", nombreLibro=" + nombreLibro + ", precioLibro=" + precioLibro + ", nombreCliente="
				+ nombreCliente + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getPrecioLibro() {
		return precioLibro;
	}
	public void setPrecioLibro(String precioLibro) {
		this.precioLibro = precioLibro;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
}
