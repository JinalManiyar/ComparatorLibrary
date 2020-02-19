package com.ComparatorLibrary.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {
	public String getData(String urlString)  {
		try {
			URL url = new URL(urlString);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			con.addRequestProperty("Connection", "keep-alive");
			con.connect();

			//If status code is not 200 then we assume it as blank response
			if (con.getResponseCode() != 200) {
				return "{}";
			}

			StringBuilder sb = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			}

			return sb.toString();
		} catch (IOException ex) {
			return "{}";
		}

	}
}
