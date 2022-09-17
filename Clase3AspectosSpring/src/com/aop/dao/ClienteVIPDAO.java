package com.aop.dao;

import org.springframework.stereotype.Component;

@Component("clienteVIPDAO")
public class ClienteVIPDAO {
	//esta clase posee un metodo insertaCliente() al igual que la clase ClienteDao
	public void insertaCliente(){
		//aqui estaria todo el codigo de insercion en la base de datos
		//Conexion cs = new Conexion()....etc....
		System.out.println( " insertaCliente() Se inserto el clienteVIP exitosamente en la base de datos");
	}

	public void insertaClienteVIP(){
		//aqui estaria todo el codigo de insercion en la base de datos
		//Conexion cs = new Conexion()....etc....
		System.out.println( " insertaClienteVIP() Se inserto el clienteVIP exitosamente en la base de datos");
	}
	
	public void insertaClienteVIPConError() throws Exception{
		//aqui estaria todo el codigo de insercion en la base de datos
		//Conexion cs = new Conexion()....etc....
		System.out.println( " insertaClienteVIPConError() ERROR NO Se inserto el clienteVIP en la base de datos");
		
		//Forzamos una Exception , esta podria simular quizas un bloqueo en la base de datos ... un fichero tomado ....etc
		throw new Exception();
	}
	
}
