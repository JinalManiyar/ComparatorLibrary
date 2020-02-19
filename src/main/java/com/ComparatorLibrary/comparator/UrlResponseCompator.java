package com.ComparatorLibrary.comparator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ComparatorLibrary.ConsolePrinter;
import com.ComparatorLibrary.util.FileReaderUtil;
import com.ComparatorLibrary.util.HttpUtil;
import com.ComparatorLibrary.util.JsonParseUtil;
import com.ComparatorLibrary.util.ResponseCompareUtil;

public class UrlResponseCompator {

	
	private List<String> file1Lines ;
	private List<String> file2Lines ;
	
	private FileReaderUtil fileReaderUtil =  new FileReaderUtil();
	
	private HttpUtil httpUtil = new HttpUtil();
	
	private JsonParseUtil jsonParseUtil = new JsonParseUtil();

	private ResponseCompareUtil responseCompareUtil = new ResponseCompareUtil();
	
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	
	// init method to read files line by line
	public void init(String file1, String file2) throws IOException {
		file1Lines = fileReaderUtil.readAllLines(file1);
		file2Lines =  fileReaderUtil.readAllLines(file2);
	}

	//execute method to get reposnse and comapre it
	public void execute() throws IOException {
		
		//Check if both files have equal no. of URL to avoid arrayoutofboundsexception 
		int length =  file1Lines.size()>file2Lines.size() ? file1Lines.size():file2Lines.size();
		String response1,response2;
		
		for(int i=0 ;i <length;i++) {
			//Get the response
			response1 = httpUtil.getData(file1Lines.get(i));
			response2 = httpUtil.getData(file2Lines.get(i));
			
			//Parse json response
			Map<String,String> response1Map = jsonParseUtil.parseResponse(response1);
			Map<String,String> response2Map = jsonParseUtil.parseResponse(response2);
			
			//Comapre 2 json response
			boolean result = responseCompareUtil.compare(response1Map,response2Map);
			
			//Print response
			consolePrinter.printResult(file1Lines.get(i),file2Lines.get(i),result);
			
		}
		
	}

}
