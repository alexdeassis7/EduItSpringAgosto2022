package com.aop.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Esta clase sera nuestro aspecto , con la funcionalidad transversal que tiene que ejecutarse siempre 
//que se invoque al metodo insertaCliente()

//le indicamos que es un component
@Component
@Aspect
public class LoginConAspecto {

	// utilizamos a anotacion @Before para que se ejecute ANTES del llamado al
	// metodo insertaCliente()
	//@Before("execution(public void insertaCliente())")
	
	//que pasa si tengo mas de un metodo con el nombre insertaCliente() en varias clases ?, hagamos la prueba 
	//con la clase clienteVIPDAO y el @Before("execution(public void insertaCliente())") , el aspecto se deberia ejecutar siempre debido a que no esta haciendo 
	//una distincion por nombre de clase 
	//@Before("execution(public void insertaCliente())")
	
	//que pasa si solo se quiere que se ejecute el aspecto para los clientes VIP ? como lo resolvemos ? 
	//lo realizamos utilizando otro "PointCutExopression" , para ello simplemente debemos incluir la ruta en la anotacion
	//@Before ,por ejemplo : @Before("execution(public void com.aop.dao.ClienteVIPDAO.insertaCliente())")
	//@Before("execution(public void com.aop.dao.ClienteVIPDAO.insertaCliente())")
	
	
	//y que pasa si quiero que se ejecute para todos los metodos que se llaman insertaXXXXXXX()
	//lo que debemos realizar en estos casos es crear un pointCut de la siguiente manera,
	//Ejemplo :@Before("execution(public void inserta*())")
	@Before("execution(public void inserta*())")
	public void antesInsertaCliente() {
		System.out.println("Se comprobo y el usuario esta correctamente logeado ");
		System.out.println(
				"Se comprobo el Rol del usuario previamente logeado y es el correcto , asi que puede insertar en la DB");
	}
	
	
	//esta anotacion ejecuta un advice despues de la ejecucion del pointCut especificado
	//siempre que le metodo del pointCut retorne de forma "normal" osera sin lanzar ninguna Exception
	@AfterReturning("execution(public void insertaCliente())")
	public void despuesDeInsertarUnCliente(){
		System.out.println("Este metodo se ejecutara despues que finalice el/los metodo/s insertaCliente() , siempre y cuando no se genere una exception");
	}
	
	
	@AfterThrowing(pointcut = "execution(public * insertaClienteVIPConError())", throwing = "daoe")
	public void despuesDeInsertarClienteConError(Exception daoe){
		//aqui podriamos poner codigo que dispare una alerta al equipo de monitoreo de la empresa 
		//o que envie un mail al responsable de la aplicacion
		System.out.println("este metodo se ejecutara despues de que finalice el metodo insertaClienteVIPConError() siemrpe y cuando el metodo lance una Exception");
	}
	
	
	
	
	
	
	


	//en este caso creamos un aspeto que escanea todo el paque sin diferencia por nombre de metodo o clase
	@Around("execution(* com.aop.dao.*.*(..))")//* com.javatpoint.service.BankService.*(..)
	//@Before("execution(public void insertaCliente())")
	public Object calculoEjecucionMetodo(ProceedingJoinPoint jointPoint) throws Throwable {
		long tiempo1 = System.currentTimeMillis();
		Object resultado = jointPoint.proceed();
		long tiempo2 = System.currentTimeMillis();
		long tiempoDeEjecucionDelMetodo = tiempo2 - tiempo1;
		if (tiempoDeEjecucionDelMetodo > 1000) {
			System.out.println("Metodo Lento avisar al DBA que revise por que la base responde lenta:"
					+ jointPoint.getTarget().getClass() + " . " + jointPoint.getSignature().getName() + ":"
					+ tiempoDeEjecucionDelMetodo);
		} else {
			System.out
					.println("Metodo dentro de los tiempo de ejecucion razonables :" + jointPoint.getTarget().getClass()
							+ " . " + jointPoint.getSignature().getName() + ":" + tiempoDeEjecucionDelMetodo);
		}
		return resultado;
	}

}
