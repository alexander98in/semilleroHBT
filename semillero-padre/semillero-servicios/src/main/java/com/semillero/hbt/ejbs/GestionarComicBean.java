/**
 * GestionarComicBean.java
 */
package com.semillero.hbt.ejbs;

import java.math.BigDecimal;
import java.util.List;

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

import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarTamanioNombreComicDTO;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */

@Stateless // Cada transaccion de comporte de manera independiente
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {
	
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger LOG = Logger.getLogger(GestionarComicBean.class);
	
	private final static String MESSAGE_ERROR = "SE HA PRESENTADO EL SIGUIETE ERROR: ";
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		LOG.info("Inicia ejecución de consultarNombrePrecioComic()");
		ConsultaNombrePrecioComicDTO consultaNombrePrecio = new ConsultaNombrePrecioComicDTO();
		
		String consultarNombrePrecio = "SELECT c.nombre, c.precio "
									 + "FROM Comic c "
									 + "WHERE c.id = :idComic ";
		
		try {
			Query queryNombrePrecio = em.createQuery(consultarNombrePrecio);
			queryNombrePrecio.setParameter("idComic", idComic);
			Object[] data = (Object[]) queryNombrePrecio.getSingleResult();
			consultaNombrePrecio.setNombre((String) data[0]);
			consultaNombrePrecio.setPrecio((BigDecimal) data[1]);
			consultaNombrePrecio.setExitoso(true);
			consultaNombrePrecio.setMensajeEjecucion("La consulta se ejecuto exitosamente");
			
		} catch(NonUniqueResultException nure) {
			LOG.error(MESSAGE_ERROR + nure.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("Se encontro mas de un registro");
			
		} catch(NoResultException nre) {
			LOG.error(MESSAGE_ERROR + nre.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("La consulta no arrojo resultados");
			
		} catch(Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("Se ha presentado un error tecnico");
		}
		
//		List<ConsultaNombrePrecioComicDTO> listaResult = queryNombrePrecio.getResultList();
//		
//		if(!listaResult.isEmpty()) {
//			String nombre = listaResult.get(0).getNombre();
//			BigDecimal precio = listaResult.get(0).getPrecio();
//			consultaNombrePrecio = new ConsultaNombrePrecioComicDTO(true, "Se ha consultado exitosamente", nombre, precio);
//		} else {
//			consultaNombrePrecio = new ConsultaNombrePrecioComicDTO(true, "La consulta no arrogo resultados", null, null);
//		}
		
		LOG.info("Finaliza ejecución de consultarNombrePrecioComic()");
		return consultaNombrePrecio;
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public ConsultarTamanioNombreComicDTO consultarComicTamanioNombre(Short lengthComic) {
		
		LOG.info("Inicia ejecución de consultarNombrePrecioComic()");		
		ConsultarTamanioNombreComicDTO consultaTamanioNombres = new ConsultarTamanioNombreComicDTO();
		
//		String consultarNombres = "SELECT nombre "
//									 + "FROM Comic "
//									 + "WHERE length(Comic.nombre) > :lengthComic ";
		
		String consultarNombres = "SELECT nombre "
				 				+ "FROM Comic ";
				
		try {
			
			if(lengthComic > 30)
			{
				throw new Exception("La longitud máxima permitida es de 30 caracteres");
			}
			Query queryNombres = em.createQuery(consultarNombres);
//			queryNombres.setParameter("lengthComic", lengthComic);
			List<String> listResult= queryNombres.getResultList();
			
			if(listResult.isEmpty()) {
				consultaTamanioNombres.setMensajeEjecucion("No hay nombre que superen esa longitud");
			} else {
				
				for (String nombreComic : listResult) {
					if(nombreComic.length() >= lengthComic) {
						consultaTamanioNombres.agregarComicAComicsSuperanTamanio(nombreComic);
					}
					else
					{
						consultaTamanioNombres.agregarComicAComicsNoSuperanTamanio(nombreComic);
					}
				}
				consultaTamanioNombres.setMensajeEjecucion("Comics procesados exitosamente");
			}
			
			consultaTamanioNombres.setExitoso(true);
		} catch(NonUniqueResultException nure) {
			LOG.error(MESSAGE_ERROR + nure.getMessage());
			consultaTamanioNombres.setExitoso(false);
			consultaTamanioNombres.setMensajeEjecucion("Se encontro mas de un registro");
			
		} catch(NoResultException nre) {
			LOG.error(MESSAGE_ERROR + nre.getMessage());
			consultaTamanioNombres.setExitoso(false);
			consultaTamanioNombres.setMensajeEjecucion("La consulta no arrojo resultados");
			
		} catch(Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			consultaTamanioNombres.setExitoso(false);
			consultaTamanioNombres.setMensajeEjecucion("Se ha presentado un error tecnico");
		}
		
		LOG.info("Finaliza ejecución de consultarNombrePrecioComic()");
		return consultaTamanioNombres;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
