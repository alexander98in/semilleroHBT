/**
 * ConsultarComics.java
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
public class ConsultarComicsDTO extends ResultadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<ComicDTO> listaComics = new ArrayList<ComicDTO>();

	/**
	 * Constructor de la clase.
	 * @param listaComics
	 */
	public ConsultarComicsDTO() {
		super();
		this.listaComics = new ArrayList<ComicDTO>();
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
	public void agregarComic(ComicDTO comic) {
		this.listaComics.add(comic);
	}
}
