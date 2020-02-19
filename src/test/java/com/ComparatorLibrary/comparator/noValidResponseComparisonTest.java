package com.ComparatorLibrary.comparator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class noValidResponseComparisonTest {

	
	UrlResponseCompator urlResponseCompator = new UrlResponseCompator();

	@Test
	public void noValidResponseComparisonTest() throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		urlResponseCompator.init("src/test/resources/file5.txt", "src/test/resources/file6.txt");
		urlResponseCompator.execute();
		System.setOut(old);
		String expectedOutput = "res.in/api/users?page=1 not equals https://reqres.in/api/users/2"+System.lineSeparator();
		Assert.assertEquals(new String(baos.toByteArray()), expectedOutput);
	}
}
