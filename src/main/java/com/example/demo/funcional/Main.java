package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {

		// *****************************Metodos High Order*****************************
		LOG.info("*****************************Metodos High Order*****************************");
		// Supplier
		LOG.info("Supplier");
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodoSupplier(supplierHO);

		// 2. Lambda

		MetodosHighOrder.metodoSupplier(() -> "17123456789HO");

		// 3. metodos referenciados
		LOG.info("Metodo referenciado>>");
		MetodosHighOrder.metodoSupplier(MetodosReferenciados::getIdHO);

		// Consumer
		LOG.info("Consumer");
		// 1. Clase
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Hola2");

		// 2. Lambda
		MetodosHighOrder.metodoConsumer((str) -> LOG.info("lambda " + str), "hola3");

		// 3. metodos referenciados
		LOG.info("Metodo referenciado>>");
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::acceptar, "Hola4");

		// Predicate
		LOG.info("Predicate");
		// 1.- Clase
		MetodosHighOrder.metodoPredicate(new PersonaPredicateImpl(), 23);

		// 2.- Lambda
		MetodosHighOrder.metodoPredicate((numero) -> {
			LOG.info("Lambda HO");
			return numero.compareTo(0) >= 0;
		}, -8);
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, -7);

		// Function
		LOG.info("Function");
		// 1.- Clase
		MetodosHighOrder.metodoFunction(new PersonaFunctionImpl(), "321654");

		// 2.- Lambda
		MetodosHighOrder.metodoFunction((arg) -> Integer.valueOf(arg) * 1000, "654987");
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicar, "987897");

		// Unary operator
		LOG.info("Unary operator");
		// 1.- Clase
		MetodosHighOrder.metodoUnaryOperator(new PersonaUnaryOperatorImpl(), "main HO UO");

		// 2.- Lambda
		MetodosHighOrder.metodoUnaryOperator((cadena) -> cadena + "Lambda HO", "Daniel main UO");
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicarStrStr, "asdf");

		/*
		 * // *********************Interfaces funcionales Java********************* LOG.
		 * info("**************************Interfaces funcionalesJava**************************"
		 * ); // 1.- Suplier
		 * 
		 * Stream<String> lista = Stream.generate(() -> "17123456798").limit(10);
		 * lista.forEach(cadena -> LOG.info(cadena.toString()));
		 * 
		 * // 2.- Consumer List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6,
		 * 7, 8, 9, 10, 11, 12, 13); listaNumeros.forEach(cadena -> {
		 * 
		 * LOG.info(cadena.toString()); }); // LOG.info("qwerwer"); //
		 * lista.forEach(LOG::info);
		 * 
		 * // 3.- Predicate Stream<Integer> listaFinal =
		 * listaNumeros.stream().filter(numero -> numero.compareTo(5) >= 0);
		 * listaFinal.forEach(numero -> LOG.info("Valor: " + numero.toString()));
		 * 
		 * // 4.- Function Stream<String> listaCambiada =
		 * listaNumeros.stream().map(numero -> { Integer num = 10; num = numero + num;
		 * return "N: " + num; }); listaCambiada.forEach(cadena ->
		 * LOG.info(cadena.toString()));
		 * 
		 * // 5.- Unary Operator Stream<Integer> listaCambiada2 =
		 * listaNumeros.stream().map(numero -> { Integer num = 10; num = numero + num;
		 * return num; }); listaCambiada2.forEach(cadena ->
		 * LOG.info(cadena.toString()));
		 */
	}

}
