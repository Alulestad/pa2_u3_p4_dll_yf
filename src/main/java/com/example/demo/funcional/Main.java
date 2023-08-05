package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {

		//...............................................................
		LOG.info("***********Tarea 16: Librerías funcionales en JAVA***********");
		LOG.info("1.- Supplier y 2.- Consumer");
		// 1.- Supplier
		Stream<Integer> listaStreams = Stream.generate(MetodosReferenciados::getSuppier).limit(10);
		
		// 2.- Consumer
		listaStreams.forEach(MetodosReferenciados::acceptCosumer);
		
		// 3.- Predicate
		LOG.info("3.- Predicate");
		List<Integer> listaArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		listaArray.stream().filter(MetodosReferenciados::testPredicate).forEach((arg)->LOG.info(arg+"predicate"));;
		
		// 4.- Function
		LOG.info("4.- Funtion");
		listaArray.stream().map(MetodosReferenciados::applyFunction).forEach(LOG::info);
		
		//5.- Unary operator
		LOG.info("5.- Unary operator");
		listaArray.replaceAll(MetodosReferenciados::appyUnaryOperator);
		LOG.info(listaArray.toString());
		
		
		
		
	}

}
