/**
 * AccionesVehiculoInterface.java
 */
package com.hbt.semillero.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Interface que determina las acciones de un vehiculo
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public interface AccionesVehiculoInterface {
	
	public int obtenerVelocidadMaxima();
	
	public Long obternerPesoMaximoCarga();
	
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception;
	
	public default void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
