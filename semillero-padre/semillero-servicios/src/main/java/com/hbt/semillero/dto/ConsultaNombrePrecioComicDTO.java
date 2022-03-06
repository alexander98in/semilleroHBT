/**
 * ConsultaNombrePrecioComicDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Declaracion de los atributos de la clase ComicDTO
	 */
	private String nombre;
	private BigDecimal precio;
	
	public ConsultaNombrePrecioComicDTO() {
		super();
		//Constructor vacio
	}
	
	/**
	 * Constructor de la clase.
	 * @param exitoso
	 * @param mensaje
	 * @param nombre
	 * @param precio
	 */
	public ConsultaNombrePrecioComicDTO(boolean exitoso, String mensaje, String nombre, BigDecimal precio) {
		super(exitoso, mensaje);
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
	

	
	
}
