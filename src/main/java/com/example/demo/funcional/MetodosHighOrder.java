package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class); // slf4j

	
	public static void metodo(IPersonaSupplier<String> funcion) {
		LOG.info("HighOrder Supplier "+funcion.getId());
		
	}
	
	public static void metodoConsumer(IPersonaConsumer<String> funcion,String hola) {
		funcion.accept("D y Y HO"+hola);
		
	}
}
