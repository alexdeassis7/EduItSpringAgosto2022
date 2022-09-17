package com.aop.dao;

import org.springframework.stereotype.Component;

//esta clase debe funsionar a modo componentes y por eso agregamos
//la anotacion @Component
@Component("clienteDAO")
public class ClienteDao {

	//antes de ejecutar este metodo por detras y de forma automatica se deberia ejecutar nuestro aspecto 
	// (funcionalidad transversar a la aplicacion ) que valida / comprueba que el usuario esta correctamente 
	//logueado y que su rol es el requerido para ejecutar la accion de "insertarCliente"
	public void insertaCliente(){
		//aqui estaria todo el codigo de la insercion en la 
		//base de datos (Conecction , PreparedStatement , ... etc)
		//Conexion cn = new Conexion();	
		System.out.println("Se conecto a la base de datos Exitosamente");
		System.out.println("Se Inserto al cliente en tabla CLIENTES del MySql");
		
		//demoramos la ejecucion del metodo para ver que se dispare la alerta del @Around
		try{
			System.out.println("ejecutando Sleep en el hilo de ejecucion actual");
			Thread.sleep(1005);
			
		}catch(InterruptedException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
}
