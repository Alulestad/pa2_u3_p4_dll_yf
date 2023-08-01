package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	
	public Integer getId() {
		return 8;
	}
	
	
	public void acceptar(String arg) {
		String cadena="Daniel y Yaniry";
		
		LOG.info(cadena+" "+arg);
	}
	
	public boolean evaluar(Integer numero) {
		
		
		return numero>=0;
	}
	
	public Integer aplicar(String cadena) {
		
		return Integer.valueOf(cadena);
	}
	
	public Integer aplicar(Integer valor) {
		return valor*100;
	}
}
