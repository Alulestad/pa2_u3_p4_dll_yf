package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class); // slf4j

	
	public static Integer getId() {
		return 8;
	}
	
	public static String getIdHO() {
		LOG.info("Metodos referenciados y HO");
		return "Daniel y Yaniry";
	}
	
	public static void acceptar(String arg) {
		String cadena="Daniel y Yaniry";
		
		LOG.info(cadena+" "+arg);
	}
	
	public static boolean evaluar(Integer numero) {
		
		
		return numero>=0;
	}
	
	public static Integer aplicar(String cadena) {
		
		return Integer.valueOf(cadena);
	}
	
	public static Integer aplicar(Integer valor) {
		return valor*100;
	}
	
	
	public static String aplicarStrStr(String cadena) {
		return cadena+"A2";
	}
}
