package com.ComparatorLibrary.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

	//Store all file lines in list interface 
	public List<String> readAllLines(String file) throws IOException {
		List<String> lines = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}

}
