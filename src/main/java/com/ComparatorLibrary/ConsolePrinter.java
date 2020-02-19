package com.ComparatorLibrary;

public class ConsolePrinter {

	public void printResult(String string1, String string2, boolean result) {
		
		// Print the comparison result
		String printResult = result ? "equals" : "not equals" ;
		System.out.println(string1 + " " + printResult + " " + string2);
	}

}
