package com.ComparatorLibrary.comparator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class equalResponseComparisonTest {
	
UrlResponseCompator urlResponseCompator = new UrlResponseCompator();
	
	
	@Test
	public void equalResponseComparisonTest() throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		urlResponseCompator.init("src/test/resources/file1.txt", "src/test/resources/file2.txt");
		urlResponseCompator.execute();
		System.setOut(old);
		String expectedOutput = "https://reqres.in/api/users/2 equals https://reqres.in/api/users/2"+System.lineSeparator();
		Assert.assertEquals(new String(baos.toByteArray()), expectedOutput);
	}

}
