package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.IEmpleados;

public class DemoUnoUsoDeAnotations {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IEmpleados comercial = contexto.getBean("comercialExperimentado", IEmpleados.class);
		
		System.out.println(comercial.getTareas());
		System.out.println(comercial.getInforme());
		
		//cerrar el contexto 
		contexto.close();
		
	}

}
