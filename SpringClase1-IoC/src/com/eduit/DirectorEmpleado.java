package com.eduit;

public class DirectorEmpleado implements Empleados {
	
	//Creacion de un atributo del tipo  CreacionInformes (interface) , para la inyeccion de dependencias
	private CreacionInformes informeNuevo;
	
	//Creacion de un constructor que inyecta la dependencia 
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}	
	
	@Override
	public String getTareas() {
		return "Gestiono la nomina de todos los empleados";
	}

	@Override
	public String getInforme() {
		//utilizamos el metodo getInforme de la interface
		return "informe creado por el director :" + informeNuevo.getInforme();
	}

}
