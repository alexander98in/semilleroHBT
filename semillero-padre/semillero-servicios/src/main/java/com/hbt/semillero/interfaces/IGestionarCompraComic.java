/**
 * IGestionarCompraComic.java
 */
package com.hbt.semillero.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dto.CompraComicDTO;

/**
 * <b>Descripción:<b> Interface que determina los servicios para la compra de un 
 * comic
 * <b>Caso de Uso:<b> Semillero 2022 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Local
public interface IGestionarCompraComic {
	
	/**
	 * 
	 * Metodo encargado de realizar la compra de un comic 
	 * <b>Caso de Uso</b> Semillero 2022
	 * @author Leyder Alexander Inagan
	 * 
	 * @param cantidadComicAComprar
	 * @return Si la compra se realizo con exito o no
	 */
	public CompraComicDTO realizarCompraComic(Long idComic, Long cantidadComicAComprar);
}
