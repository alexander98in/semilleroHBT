/**
 * Bicicleta.java
 */
package com.hbt.semillero.dto;

import com.hbt.semillero.enums.TipoVehiculoEnum;

import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leyder Alexander Inagan
 * @version 1.0
 */
public class Bicicleta extends Vehiculo implements AccionesVehiculoInterface {
	
	@Override
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long obternerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
