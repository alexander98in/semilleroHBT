/**
 * GestionarCompraComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * <b>Descripción:<b> Clase que determina los servicios REST
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Path("/gestionarCompraComicRest")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	
	@GET
	@Path("/realizarCompraComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompraComicDTO realizarCompraComic(@QueryParam("idComic") Long idComic, 
			@QueryParam("cantidadComicAComprar") Long cantidadComicAComprar) {
		return this.gestionarCompraComic.realizarCompraComic(idComic, cantidadComicAComprar);
	}
}
