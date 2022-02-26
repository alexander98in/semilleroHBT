/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Enum que determina los tipo de estado
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public enum EstadoEnum {
	
	/**
	 * Declaracion de tipos del EstadoEnum
	 */
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo")
	;
	
	/**
	 * Establece la descripcion del tipo de estadoEnum
	 */
	private String descripcion;
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param descripcion
	 */
	EstadoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo descripcion
	 * @return El descripcion asociado a la clase
	 */
	public String getDescripcion() {
		return descripcion;
	}
	

}
