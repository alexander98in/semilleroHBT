/**
 * CompraComicDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <b>Descripción:<b> Clase DTO que determina el retorno del servicio de realizar compra
 * de un comic
 * <b>Caso de Uso:<b> Semillero 2020
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public class CompraComicDTO extends ResultadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombreComicComprado;
	private BigDecimal cantidadAPagar;
	
	/**
	 * Constructor vacio de la clase.
	 * 
	 */
	public CompraComicDTO() {
		super();
	}
	
	/**
	 * Constructor de la clase.
	 * @param nombreComicComprado
	 * @param cantidadAPagar
	 */
	public CompraComicDTO(String nombreComicComprado, BigDecimal cantidadAPagar) {
		super();
		this.nombreComicComprado = nombreComicComprado;
		this.cantidadAPagar = cantidadAPagar;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombreComicComprado
	 * @return El nombreComicComprado asociado a la clase
	 */
	public String getNombreComicComprado() {
		return nombreComicComprado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombreComicComprado
	 * @param nombreComicComprado El nuevo nombreComicComprado a modificar.
	 */
	public void setNombreComicComprado(String nombreComicComprado) {
		this.nombreComicComprado = nombreComicComprado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo cantidadAPagar
	 * @return El cantidadAPagar asociado a la clase
	 */
	public BigDecimal getCantidadAPagar() {
		return cantidadAPagar;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo cantidadAPagar
	 * @param cantidadAPagar El nuevo cantidadAPagar a modificar.
	 */
	public void setCantidadAPagar(BigDecimal cantidadAPagar) {
		this.cantidadAPagar = cantidadAPagar;
	}
	
	

}
