package com.example.demo.funcional;

import java.util.function.BiPredicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {
		IPersona per1 = new PersonaImpl();
		per1.caminar();

		// 1. Supplier
		// Clases:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());

		// Lambdas:
		IPersonaSupplier<String> supplier2 = () -> "17123456789";
		LOG.info("Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "17123456789";
			cedula = cedula + "zzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda 2: " + supplier3.getId());
		
		//Metodos referenciados
		MetodosReferenciados metodos=new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4=metodos::getId;
		LOG.info("Supplier metodo refenciado: " + supplier4.getId());
		

		// 2. Consumer
		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase");
		consumer1.accept("Daniel y/o Yaniry");

		// Lambdas:
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer lambda");
		consumer2.accept("Daniel y/o Yaniry");
		
		//Metodos referenciados
		IPersonaConsumer<String> consumer3=metodos::acceptar;
		LOG.info("Consumer metodo referenciado");
		consumer3.accept("Daniel3");
		
		
		// 3.- Predicate
		// Lambdas
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate lambda: " + predicate1.evaluar(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate lambda 2: " + predicate2.evaluar(95));

		IPersonaPredicate<String> predicate3 = letra -> "Daniel".contains(letra);
		LOG.info("Predicate lambda 3: " + predicate3.evaluar("D"));

		IPersonaBiPredicate<String, String> biPredicate = (nombre, letra) -> nombre.contains(letra);
		LOG.info("BiPredicate lambda: " + biPredicate.evaluar("Daniel", "D"));

		
		//Metodos referenciados
		IPersonaPredicate<Integer> predicate5=metodos::evaluar;
		LOG.info("Predicate metodo referenciado: " + predicate5.evaluar(-5));
		
		
		
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
		
		
		IPersonaUnaryOperator<Integer> unaryOperator2=metodos::aplicar2;
		LOG.info("Unary Operator metodo referenciado: " + unaryOperator2.aplicar(3));
		
		
	}

}
