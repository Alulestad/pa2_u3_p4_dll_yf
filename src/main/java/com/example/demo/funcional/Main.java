package com.example.demo.funcional;

import java.util.function.BiPredicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {
		
		MetodosReferenciados metodos=new MetodosReferenciados();
		
		// 4.- Function
		// Lambdas
		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda: " + function1.aplicar(10));
		
		
		//Metodos referenciados
		IPersonaFunction<Integer, String> function2=metodos::aplicar;
		LOG.info("Function metodo referenciado: " + function2.aplicar("100"));
		
		
		// 5.- Unary Operator
		// Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator=numero->numero+(numero*2);
		LOG.info("Unary Operator lambda: " + unaryOperator.aplicar(3));
		
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunction=numero->numero+(numero*2);
		LOG.info("Unary Operator Function lambda: " + unaryOperatorFunction.aplicar(3));
		
		
		IPersonaUnaryOperator<Integer> unaryOperator2=metodos::aplicar;
		LOG.info("Unary Operator metodo referenciado: " + unaryOperator2.aplicar(3));
		
		
	}

}
