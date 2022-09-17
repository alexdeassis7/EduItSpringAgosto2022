package com.prueba.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;
import com.interfaces.IEmpleados;

//Utilizamos una anottation y le definimos un id "comercialExperimentado" , el id no es 
//necesario que coincida con el nombre de la clase , con esto ya estaria registrado nuestro beans 
//en el container
//@Component("comercialExperimentado")//registramos el beans
//podemos presindir de darle un un nombre o id al component
//asi spring lo que hace es tomar como id al nombre de la clase pero con la primera letra en minuscula
//esntonces debemos tener mucho cuidado cuando ponemos los nombres de clases 
@Component

//con la anotation @Scope : modificamos para que duse el patron prototype o el singleton 
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {

	//utilizamos este campo para la inyeccion de dependencias
	private CreacionInformesFinancieros informeNuevo;
	
	@Override
	public String getTareas() {
		
		return "soy un vendedor y me encargo de vender mucho !";
	}

	//creamos un constructor para que a traves de este constructor pueda 
	//spring inyectar la dependencia con la anottaion @autowired.
	//si existe una clase que implemente la interface "CreacionInformesFinancieros"
	//es de esa clase de donde obtendra la inyeccion de dependencia , en este caso 
	//encontraria la clase "InformeFinancieroTrimestre1", una vez que spring 
	//detecta la clase  despues nosotros solamente deberiamos llamar al metodo getInforme()
	@Autowired
	//si comentamos el @Autowired todo seguira funcionando , en las ultimas versiones
	// de spirng no es necesesario utilizarlo SI EL BEAN QUE NECESITA LA DEPENDENCIA 
	//define solamente un unico constructor  (que es justo nuestro caso) 
	//buena practica UTILIZAR SIEMPRE el @Autowired
	//Autowired tambien se puede implementar en atributos (mediante el concepto de reflexion)
	//e incluso tambien en los setters
	 public ComercialExperimentado(CreacionInformesFinancieros informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	
	@Override
	public String getInforme() {
		//utilizamos el metodo getInforme (sin la inyeccion de dependencia)
		//return "Informe creado por el comercial con mucha experiencia en informes";
		
		//utilizamos el metodo getInforme de la interface (con @Autowired implemendado)
		return informeNuevo.getInformeFinanciero();
	}

	//para usar PostConstruct y PreDestroy SI O SI debemos utilizar el scope  por default  (singleton)
	//esto se debe a que spring no maneja el ciclo de vida por completo del bean si trabajamos con un scope 
	//del tipo prototype 
	
	//ejecucion de codigo despues de la creacion dell bean 
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("ejecutando tras la creacion del bean ");
	}
	
	//ejecucion de codigo depues del apagado del contenedor de spring 
	@PreDestroy
	public void ejecutaCreacion() {
		System.out.println("ejecutando codigo antes de la destruccion del bean ");
	}
	
	
	
	
	
	
}
