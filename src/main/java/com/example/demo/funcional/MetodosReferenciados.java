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
	
	//suplier
	public static Integer getSuppier() {
		Integer num=Integer.valueOf((int)(Math.random()*100)) ;
		LOG.info("Valor generado en getSupplier: "+num);
		return num;
	}

	//consumer
	public static void acceptCosumer(Integer valor) {
		
		LOG.info("acceptConsumer: "+valor);
	}
	
	//predicate
	public static boolean testPredicate(Integer valor) {
		
		return (valor.intValue()%2==0)?true:false;
	}
	
	//function
	public static String applyFunction(Integer valor) {
		
		return valor.toString()+"function";
	}
	
	//Unary Operator
	
	public static Integer appyUnaryOperator(Integer valor) {
		
		return valor+3;
	}
	
}
