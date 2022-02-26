/**
 * CreacionComicTest.java
 */
package com.hbt.semillero.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que hace el test de la creacion de comic 
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public class CreacionComicTest {
	
	/**
	 * Constante que contiene la informacion de los logs a manejar en la clase CreacionComicTest
	 */
	private final static Logger LOG = Logger.getLogger(OperacionesAritmeticasTest.class);
	private List<ComicDTO> listaComicsDTO = new ArrayList<ComicDTO>();
	
	private void creacionComics()
	{
		//Creacion de los comics
		ComicDTO comic01 = new ComicDTO(1L, "Comic 01", "Editorial 01", TematicaEnum.AVENTURAS, "Coleccion 01", 
				50, 300, "Autores 01", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic02 = new ComicDTO(2L, "Comic 02", "Editorial 02", TematicaEnum.AVENTURAS, "Coleccion 02", 
				50, 300, "Autores 02", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic03 = new ComicDTO(3L, "Comic 03", "Editorial 03", TematicaEnum.AVENTURAS, "Coleccion 03", 
				50, 300, "Autores 03", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic04 = new ComicDTO(4L, "Comic 04", "Editorial 04", TematicaEnum.AVENTURAS, "Coleccion 04", 
				50, 300, "Autores 04", false, LocalDate.now(), EstadoEnum.INACTIVO, 5);
		ComicDTO comic05 = new ComicDTO(5L, "Comic 05", "Editorial 05", TematicaEnum.AVENTURAS, "Coleccion 05", 
				50, 300, "Autores 05", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic06 = new ComicDTO(6L, "Comic 06", "Editorial 06", TematicaEnum.AVENTURAS, "Coleccion 06", 
				50, 300, "Autores 06", false, LocalDate.now(), EstadoEnum.INACTIVO, 5);
		ComicDTO comic07 = new ComicDTO(7L, "Comic 07", "Editorial 07", TematicaEnum.AVENTURAS, "Coleccion 07", 
				50, 300, "Autores 07", false, LocalDate.now(), EstadoEnum.INACTIVO, 5);
		ComicDTO comic08 = new ComicDTO(8L, "Comic 08", "Editorial 08", TematicaEnum.AVENTURAS, "Coleccion 08", 
				50, 300, "Autores 08", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic09 = new ComicDTO(9L, "Comic 08", "Editorial 09", TematicaEnum.AVENTURAS, "Coleccion 09", 
				50, 300, "Autores 09", false, LocalDate.now(), EstadoEnum.ACTIVO, 5);
		ComicDTO comic10 = new ComicDTO(10L, "Comic 10", "Editorial 10", TematicaEnum.AVENTURAS, "Coleccion 10", 
				50, 300, "Autores 10", false, LocalDate.now(), EstadoEnum.INACTIVO, 5);
				
		//Agrego los comics a la lista
		this.listaComicsDTO.add(comic01);
		this.listaComicsDTO.add(comic02);
		this.listaComicsDTO.add(comic03);
		this.listaComicsDTO.add(comic04);
		this.listaComicsDTO.add(comic05);
		this.listaComicsDTO.add(comic06);
		this.listaComicsDTO.add(comic07);
		this.listaComicsDTO.add(comic08);
		this.listaComicsDTO.add(comic09);
		this.listaComicsDTO.add(comic10);
				
		//this.listaComicsDTO = Arrays.asList(comic01, comic02);	
	}
	
	/**
	 * 
	 * Metodo encargado de filtrar los comics con el estado activo
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Inagan Pinchao
	 * 
	 * @return
	 */
	private List<ComicDTO> obtenerComicsActivos()
	{
		List<ComicDTO> listaComicsActivos = new ArrayList<ComicDTO>();
		
		for (ComicDTO comicDTO : this.listaComicsDTO) {
			if(comicDTO.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
				listaComicsActivos.add(comicDTO);
			}
		}
		return listaComicsActivos;
	}
	
	/**
	 * 
	 * Metodo encargado de filtrar los comics con el estado inactivo
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 * 
	 * @return
	 */
	private List<ComicDTO> obtenerComicsInactivos()
	{
		/**return listaComicsDTO.stream().filter(s -> s.getEstadoEnum()
		*		.equals(EstadoEnum.INACTIVO))
		*		.collect(Collectors.toList());
		**/
		List<ComicDTO> listaComicsInactivos = new ArrayList<ComicDTO>();
		
		for (ComicDTO comicDTO : this.listaComicsDTO) {
			if(comicDTO.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
				listaComicsInactivos.add(comicDTO);
			}
		}
		return listaComicsInactivos;
	}
	
	/**
	 * 
	 * Metodo encargado de generar un mensaje mediente una excepcion
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 * 
	 * @throws Exception
	 */
	private void generarMensaje() throws Exception
	{
		throw new Exception("Se ha detectado que de " + this.listaComicsDTO.size() + "comics, se encontraron que " 
								+ this.obtenerComicsActivos().size() + " se encuentran activos y " 
								+ this.obtenerComicsInactivos().size() + " inactivos. Los comics inactivos son: " 
								+ this.obtenerComicsInactivos().size() + ".");	
	}
	
	/**
	 * --------------------------------------------------------------------
	 * Inicio de las pruebas
	 * --------------------------------------------------------------------
	 */
	
	/**
	 * 
	 * Metodo encargado de inicializar
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 *
	 */
	@BeforeTest
	public void inicializar() {
		// Inicializa el looger con una configuracion por default o basica.
		
		this.creacionComics();
		BasicConfigurator.configure();
		LOG.info(":::::::::::: INICIAN PRUEBAS UNITARIAS ::::::::::::");
	}
	
	/**
	 * 
	 * Prueba unitaria encargada de validar que se obtengan los comics con estado activo 
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 *
	 */
	@Test(enabled = true)
	public void validarListaComicsEnEstadoActivo()
	{
		LOG.info("Inicia ejecucion del test validarListaComicsEnEstadoActivo()");
		
		Assert.assertEquals(6, this.obtenerComicsActivos().size());
		
		//this.obtenerComicsActivos().stream().forEach(s -> System.out.println(s));
		for (ComicDTO comicDTO : this.obtenerComicsActivos()) {
			System.out.println(comicDTO.toString());
		}
		
		LOG.info("Finaliza la ejecucion del test validarListaComicsEnEstadoActivo()");
	}
	
	/**
	 * 
	 * Prueba unitaria donde se captura el mensaje de excepcion 
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 *
	 */
	@Test(enabled = true)
	public void capturarMensajeDeExcepcion()
	{
		LOG.info("Inicia ejecucion del test capturarMensajeDeExcepcion()");
		
		try
		{
			LOG.info("Cuerpo del try");
		} catch(Exception e) {
			LOG.error("El error esperado es: " + e.getMessage());
			Assert.assertEquals(e.getMessage(), "Se ha detectado que de " + this.listaComicsDTO.size() + "comics, se encontraron que " + 
													this.obtenerComicsActivos().size() + " se encuentran activos y " + 
													this.obtenerComicsInactivos().size() + " inactivos. Los comics inactivos son: " + 
												    this.obtenerComicsInactivos().size() + ".");
		}
		LOG.info("Finaliza la ejecucion del test capturarMensajeDeExcepcion()");
		
	}
	
	/**
	 * 
	 * Metodo encargado de finalizar las pruebas unitarias
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author Leyder Alexander Inagan
	 *
	 */
	@AfterTest
	public void finalizar() {
		LOG.info("::::::::::::: FINALIZAN LAS PRUEBAS UNITARIAS :::::::::::::");
	}
}
