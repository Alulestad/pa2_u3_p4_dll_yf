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

		MetodosReferenciados metodos = new MetodosReferenciados();

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

		// Metodos referenciados
		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getId;
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

		// Metodos referenciados
		IPersonaConsumer<String> consumer3 = MetodosReferenciados::acceptar;
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

		// Metodos referenciados
		IPersonaPredicate<Integer> predicate5 = MetodosReferenciados::evaluar;
		LOG.info("Predicate metodo referenciado: " + predicate5.evaluar(-5));

		// 4.- Function
		// Lambdas
		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda: " + function1.aplicar(10));

		// Metodos referenciados
		IPersonaFunction<Integer, String> function2 = MetodosReferenciados::aplicar;
		LOG.info("Function metodo referenciado: " + function2.aplicar("100"));

		// 5.- Unary Operator
		// Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator = numero -> numero + (numero * 2);
		LOG.info("Unary Operator lambda: " + unaryOperator.aplicar(3));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunction = numero -> numero + (numero * 2);
		LOG.info("Unary Operator Function lambda: " + unaryOperatorFunction.aplicar(3));

		IPersonaUnaryOperator<Integer> unaryOperator2 = MetodosReferenciados::aplicar;
		LOG.info("Unary Operator metodo referenciado: " + unaryOperator2.aplicar(3));

		// 4.- Function
		// Lambdas
		IPersonaFunction<String, Integer> function12 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda: " + function12.aplicar(10));

		// Metodos referenciados
		IPersonaFunction<Integer, String> function22 = MetodosReferenciados::aplicar;
		LOG.info("Function metodo referenciado: " + function22.aplicar("100"));

		// 5.- Unary Operator
		// Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator21 = numero -> numero + (numero * 2);
		LOG.info("Unary Operator lambda: " + unaryOperator21.aplicar(3));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunction2 = numero -> numero + (numero * 2);
		LOG.info("Unary Operator Function lambda: " + unaryOperatorFunction2.aplicar(3));

		IPersonaUnaryOperator<Integer> unaryOperator22 = MetodosReferenciados::aplicar;
		LOG.info("Unary Operator metodo referenciado: " + unaryOperator22.aplicar(3));

		// *****************************Metodos High Order*****************************
		MetodosHighOrder highOrder = new MetodosHighOrder();
		// Supplier
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodo(supplierHO);

		// 2. Lambda
		
		MetodosHighOrder.metodo(() -> "17123456789HO");
		
		// 3. metodos referenciados
		MetodosHighOrder.metodo(MetodosReferenciados::getIdHO);

		// Consumer
		// 1. Clase
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(),"Hola2");

		// 2. Lambda
		MetodosHighOrder.metodoConsumer((str) -> LOG.info("lambda "+str),"hola3");

		// 3. metodos referenciados
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::acceptar,"Hola4");
		
		// *****************************Interfaces funcionales Java*****************************
		//1.- Suplier
		
		Stream<String> lista= Stream.generate(()->"17123456798").limit(10);
		lista.forEach(cadena->LOG.info(cadena.toString()));
		
		//2.- Consumer
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		listaNumeros.forEach(cadena->{

			LOG.info(cadena.toString());
		});
		//LOG.info("qwerwer");
		//lista.forEach(LOG::info);
		
		//3.- Predicate
		Stream<Integer> listaFinal= listaNumeros.stream().filter(numero->numero.compareTo(5)>=0);
		listaFinal.forEach(numero->LOG.info("Valor: "+numero.toString()));
		
		//4.- Function
		Stream<String> listaCambiada= listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return "N: "+num;
		});
		listaCambiada.forEach(cadena->LOG.info(cadena.toString()));
		
		
		//5.- Unary Operator
		Stream<Integer> listaCambiada2= listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return num;
		});
		listaCambiada2.forEach(cadena->LOG.info(cadena.toString()));
		
		
	}
	

}
