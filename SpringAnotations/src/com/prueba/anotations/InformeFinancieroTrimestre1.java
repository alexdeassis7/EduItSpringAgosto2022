package com.prueba.anotations;

import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;

//Esta clase es la dependencia de la clase Comercial Experimentado 


@Component //registramos la clase en el containner de spring 
public class InformeFinancieroTrimestre1 implements CreacionInformesFinancieros {

	@Override
	public String getInformeFinanciero() {
	
		return "esta es una presentacion de un informe fiannciero del primer trimestre del año ";
	}

}
