package com.eduit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoUsoEmpleado {

	public static void main(String[] args) {
		
		//paso 1 cargar el xml 
		//primero creamos un contexto y poenemos el nombre de nuestro archivos xml de conf
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//paso 2 solicitarle el beans al contenedor , pasandole el alias o id y en segundo lugar el nombre de la interface
		Empleados Juan = contexto.getBean("miEmpleado", Empleados.class);
		
		//paso 3 utilizamos el objeto 
		
		System.out.println("Utilizamos el bean : " + Juan.getInforme());
		System.out.println("Utilizamos el bean : " + Juan.getTareas());
		
		//paso 4 :cerramos el contexto
		contexto.close();
		
	}

}
