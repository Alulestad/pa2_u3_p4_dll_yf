package com.example.demo.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate<Integer> {

	@Override
	public boolean evaluar(Integer arg) {
				
		return arg.compareTo(0)>=0;
	}

	
	
}
