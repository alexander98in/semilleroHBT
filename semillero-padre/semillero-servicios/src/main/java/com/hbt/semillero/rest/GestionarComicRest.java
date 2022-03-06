/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarTamanioNombreComicDTO;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Path("/gestionarComicRest")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	
	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic)
	{
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsultarTamanioNombreComicDTO consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic)
	{
		return this.gestionarComicLocal.consultarComicTamanioNombre(lengthComic);
	}
}
