/**
 * ConsultarTamanioNombreComicDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public class ConsultarTamanioNombreComicDTO extends ResultadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declaracion de los atributos de la clase ConsultarTamanioNombreComicDTO
	 */
	
	private List<String> comicsSuperanTamanio = new ArrayList<String>();
	private List<String> comicsNoSuperanTamanio = new ArrayList<String>();
	
	/**
	 * 
	 * Constructor VACIO de la clase.
	 */
	public ConsultarTamanioNombreComicDTO() {
		//Constructro vacio
		super();
	}

	/**
	 * Constructor de la clase.
	 * @param comicsSuperanTamanio
	 * @param comicsNoSuperanTamanio
	 */
	public ConsultarTamanioNombreComicDTO(List<String> comicsSuperanTamanio, List<String> comicsNoSuperanTamanio) {
		super();
		this.comicsSuperanTamanio = comicsSuperanTamanio;
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo comicsSuperanTamanio
	 * @return El comicsSuperanTamanio asociado a la clase
	 */
	public List<String> getComicsSuperanTamanio() {
		return comicsSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comicsSuperanTamanio
	 * @param comicsSuperanTamanio El nuevo comicsSuperanTamanio a modificar.
	 */
	public void setComicsSuperanTamanio(List<String> comicsSuperanTamanio) {
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo comicsNoSuperanTamanio
	 * @return El comicsNoSuperanTamanio asociado a la clase
	 */
	public List<String> getComicsNoSuperanTamanio() {
		return comicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comicsNoSuperanTamanio
	 * @param comicsNoSuperanTamanio El nuevo comicsNoSuperanTamanio a modificar.
	 */
	public void setComicsNoSuperanTamanio(List<String> comicsNoSuperanTamanio) {
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
	}

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author MIPC
	 * 
	 * @param nombreComic
	 */
	public void agregarComicAComicsSuperanTamanio(String nombreComic)
	{
		this.comicsSuperanTamanio.add(nombreComic);
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author MIPC
	 * 
	 * @param nombreComic
	 */
	public void agregarComicAComicsNoSuperanTamanio(String nombreComic)
	{
		this.comicsNoSuperanTamanio.add(nombreComic);
	}
	
}
