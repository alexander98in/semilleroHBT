/**
 * TematicaEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Enum que determina los tipos de tematica
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author MIPC
 * @version 
 */
public enum TematicaEnum {
	
	/**
	 * Declaracion de tipos de la Tematica	
	 */
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"),
	HISTORICO("enum.tematica.aventuras.historico"),
	HORROR("enum.tematica.aventuras.horror"),
	HUMORISTICO("enum.tematica.aventuras.humoristico")
	;
	
	/**
	 * Establece la descripcion para los tipos de la TematicaEnum
	 */
	private String descripcion;
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param descripcion
	 */
	TematicaEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * 
	 * Metodo encargado de retornar la descripcion
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
}
