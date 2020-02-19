package com.ComparatorLibrary;

import java.io.IOException;

import com.ComparatorLibrary.comparator.UrlResponseCompator;

public class Runner {
	
	private final UrlResponseCompator urlResponseCompator = new UrlResponseCompator();

	public static void main(String[] args) throws IOException {

		//Handled exception if user provides one file name
		if(args.length < 2) {
			throw new IllegalArgumentException("Usage: java Runner file1 file2");
		}
		
		Runner runner = new Runner();
		
		long start  =System.currentTimeMillis();
		
		//Initialize file reading for 2 files from console
		runner.urlResponseCompator.init(args[0],args[1]);
		
		//Get the response and bompare it
		runner.urlResponseCompator.execute();
		
		long end  = System.currentTimeMillis();
		System.out.println((end-start)/1000 + "seconds");
		
		
	}
}
