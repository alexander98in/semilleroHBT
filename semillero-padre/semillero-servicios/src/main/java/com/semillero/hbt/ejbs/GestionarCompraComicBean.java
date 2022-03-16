/**
 * GestionarCompraComicBean.java
 */
package com.semillero.hbt.ejbs;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * <b>Descripción:<b> Clase que implementa la funcionalidad de los servicios REST con JPQL
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
@Stateless // Cada transaccion de comporte de manera independiente
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {
	
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger LOG = Logger.getLogger(GestionarComicBean.class);
	
	private final static String MESSAGE_ERROR = "SE HA PRESENTADO EL SIGUIETE ERROR: ";
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@SuppressWarnings("unchecked")
	public CompraComicDTO realizarCompraComic(Long idComic, Long cantidadComicAComprar) {
		LOG.info("Inicia la ejecución de realizarCompraComic()");
		CompraComicDTO compraComic = new CompraComicDTO();
		compraComic.setCantidadAPagar(new BigDecimal("00.00"));
		
		String consultarComicAComprar = "SELECT c "
									  + "FROM Comic c "
									  + "WHERE c.id = :idComic";
		try {
			Query queryComicAComprar = em.createQuery(consultarComicAComprar);
			queryComicAComprar.setParameter("idComic", idComic);
			Comic comicAComprar = (Comic) queryComicAComprar.getSingleResult();
			
			if(comicAComprar != null) {
				compraComic.setExitoso(true);
				compraComic.setMensajeEjecucion("La compra del comic no fue exitosa.");
				if(comicAComprar.getEstadoEnum().equals(EstadoEnum.INACTIVO))
				{
					throw new Exception("El comic seleccionado no cuenta con stock en bodega.");
				}
				
				//Cantidad de comics a comprar
				if(cantidadComicAComprar > comicAComprar.getCantidad()) 
				{
					throw new Exception("La cantidad existente del comic es: " + comicAComprar.getCantidad() + ", y supera la ingresada.");
				}
				else if(cantidadComicAComprar < comicAComprar.getCantidad())
				{
					//Obtenemos lo que tiene que pagar
					BigDecimal cantidadAComprar = new BigDecimal(cantidadComicAComprar);
					BigDecimal totalAPagar = cantidadAComprar.multiply(comicAComprar.getPrecio());
					
					//Actualizamos el comic
					Comic comicActualizar = em.find(Comic.class, comicAComprar.getId());
					comicActualizar.setCantidad(comicActualizar.getCantidad() - cantidadComicAComprar);
					comicActualizar.setFechaVenta(LocalDate.now());
					em.merge(comicActualizar);
	
					//Se efectuo la compra
					compraComic.setNombreComicComprado(comicAComprar.getNombre());
					compraComic.setCantidadAPagar(totalAPagar);
					compraComic.setMensajeEjecucion("La compra del comic fue exitosa");					
				}
				else
				{
					//Obtenemos lo que tiene que pagar
					BigDecimal cantidadAComprar = new BigDecimal(cantidadComicAComprar);
					BigDecimal totalAPagar = cantidadAComprar.multiply(comicAComprar.getPrecio());
					
					//Actualizamos el comic
					Comic comicActualizar = em.find(Comic.class, comicAComprar.getId());
					comicActualizar.setCantidad(comicActualizar.getCantidad() - cantidadComicAComprar);
					comicActualizar.setFechaVenta(LocalDate.now());
					comicActualizar.setEstadoEnum(EstadoEnum.INACTIVO);
					em.merge(comicActualizar);
					
					//Obtenemos lo que tiene que pagar
					LOG.info("Info del comic a comprar: " + comicAComprar + " precio a pagar: " + totalAPagar);
					compraComic.setNombreComicComprado(comicAComprar.getNombre());
					compraComic.setCantidadAPagar(totalAPagar);
					compraComic.setMensajeEjecucion("La compra del comic fue exitosa");
				}
			}
			
			LOG.info("Info del comic a comprar: " + comicAComprar);
		} catch(NonUniqueResultException nure) {
			LOG.error(MESSAGE_ERROR + nure.getMessage());
			compraComic.setExitoso(false);
			compraComic.setMensajeEjecucion("Se encontro mas de un registro, por lo tanto la compra no se realizo con exito.");
			
		} catch(NoResultException nre) {
			LOG.error(MESSAGE_ERROR + nre.getMessage());
			compraComic.setExitoso(false);
			compraComic.setMensajeEjecucion("La consulta no arrojo resultados, por lo tanto la compra no se realizo con exito.");
		} catch(Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			compraComic.setExitoso(false);
			compraComic.setMensajeEjecucion("Se ha presentado un error tecnico al realizar la compra del comic." + e.getMessage());
		}
		
		return compraComic;
	}

	

}
