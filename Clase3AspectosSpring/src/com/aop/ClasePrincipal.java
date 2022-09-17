package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.ClienteDao;
import com.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {
	public static void main(String[] args) {

		// levantamos la configuracion , esta vez ya no posee un archivo .xml
		// pero si podemos utilizar nuestra
		// clase previamente creada con @Configuration
		// le indicamos al constructor de la clase que tome la clase
		// "Configuracion"
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);


		// obtengo el bean del contenedor de Spring
		ClienteDao miCliente = contexto.getBean("clienteDAO", ClienteDao.class);

		// obtengo el bean del contenedor de Spring
		ClienteVIPDAO miClienteVIP = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);

		// llamamos al metodo insertaCliente de la clase ClienteDao
		System.out.println("*************************** miCliente.insertaCliente()  ***************************");
		miCliente.insertaCliente(); // este es el nombre del metodo que debe
									// coincidir con la anotacion @Before del
									// aspecto

		// llamamos al metodo insertaCliente de la clase ClienteVIPDAO
		System.out.println("*************************** miClienteVIP.insertaCliente()  ***************************");
		// este es el nombre del metodo que debe coincidir con la anotacion
		// @Before del aspecto
		miClienteVIP.insertaCliente();

		// llamamos al metodo insertaClienteVIP de la clase ClienteVIPDAO
		System.out.println("*************************** miClienteVIP.insertaClienteVIP()  ***************************");
		// este es el nombre del metodo que debe coincidir con la anotacion
		// @Before del aspecto
		miClienteVIP.insertaClienteVIP();

		// llamamos al metodo insertaClienteVIPConError de la clase
		// ClienteVIPDAO
		System.out.println(
				"*************************** miClienteVIP.insertaClienteVIPConError()  ***************************");
		// este es el nombre del metodo que debe coincidir con la anotacion
		// @Before del aspecto
		try {
			miClienteVIP.insertaClienteVIPConError();
		} catch (Exception e) {
			System.out.println("Se capturo una Exception al intentar agregar un cliente VIP");
		}

		// cerramos el contexto y liberamos recursos
		contexto.close();
	}
}
