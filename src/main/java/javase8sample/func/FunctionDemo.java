package javase8sample.func;

import java.util.function.Function;

public class FunctionDemo {

	// API which accepts an implementation of

	// Function interface

	static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {

		int newValue = function.apply(valueToBeOperated);

		/*
		 * Do some operations using the new value.
		 */

		System.out.println(newValue);

	}
	
	static void compose(int valueToBeOperated, Function<Integer, Integer> function, Function<Integer, Integer> before) {
		
		int newValue = function.compose(before).apply(valueToBeOperated);
		
		/*
		 * Do some operations using the new value.
		 */
		System.out.println(newValue);
	}
	
	static void andThen(int valueToBeOperated, Function<Integer, Integer> function, Function<Integer, Integer> after) {

		int newValue = function.andThen(after).apply(valueToBeOperated);

		/*
		 * Do some operations using the new value.
		 */
		System.out.println(newValue);
	}
	
	public static void main(String[] args) {

	    int incr = 20;  int myNumber = 10;

	    modifyTheValue(myNumber, val-> val + incr);

	    myNumber = 15;  modifyTheValue(myNumber, val-> val * 10);

	    modifyTheValue(myNumber, val-> val - 100);

	    modifyTheValue(myNumber, val-> "somestring".length() + val - 100);
	    
	    compose(myNumber, val-> val * 20, val-> val - 5);
	    
	    andThen(myNumber, val-> val * 20, val-> val - 5);

	}

}