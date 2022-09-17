package com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//clase que configura para que spring sepa donde escanear las anotaciones
@Configuration
//habilitamos la configuracion de programacion orientada a aspectos 
@EnableAspectJAutoProxy
//escaneamos el base package
@ComponentScan("com.aop")
public class Configuracion {
  //esta clase no necesita tener codigo en su interior 
}
