/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {
	
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String generarOperacionComic() {
		Comic comic = null;

		try {
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 6;
			comic = em.find(Comic.class, 6L);
			LOG.info("DATA COMIC" + comic.toString());
			
			String consulta = "SELECT cm FROM Comic WHERE cm.id = 6 ";
			Query queryUnComic = em.createQuery(consulta);
			comic = (Comic) queryUnComic.getSingleResult();
			
			
		} catch (Exception e) {
			LOG.error("SE HA PRESENTADO UN ERROR TECNICO" + e.getMessage());
		}
		
		return "";
	}

}
