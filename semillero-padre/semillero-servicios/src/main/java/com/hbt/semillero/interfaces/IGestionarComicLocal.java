/**
 * IGestionarComicLocal.java
 */
package com.hbt.semillero.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarTamanioNombreComicDTO;

/**
 * <b>Descripción:<b> Interface que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Local
public interface IGestionarComicLocal {
	
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	/**
	 * 
	 * Metodo encargado de consultar los nombre de los comics con una longitud mayor
	 * a la que se ingresa por parametro
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 * 
	 * @param lengthComic
	 * @return Nombre de los comics con una longitud mayor al parametro
	 */
	public ConsultarTamanioNombreComicDTO consultarComicTamanioNombre(Short lengthComic);
}
