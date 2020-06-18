package com.ComparatorLibrary.util;

import java.util.Map;
import java.util.Set;

public class ResponseCompareUtil {

	public boolean compare(Map<String, String> response1, Map<String, String> response2) {

		// If number of keys of both responses are equal or not
		System.out.println("Response1 size");
		System.out.printf("response1.size()");
		System.out.println();
		if (response2.size() != response1.size()) {
			return false;
		}

		// If number of keys are equal compare keys
		Set<String> keys = response1.keySet();
		for (String key : keys) {
			if (!response2.containsKey(key)) {
				return false;
			}
		}

		//If keys are same then compare values in both response
		String val1, val2;
		for (String key : keys) {
			val1 = response1.get(key);
			val2 = response2.get(key);
			
			if (val2.contains(",")) {
				String[] valArr = val2.split(",");
				for (String val : valArr) {
					if (!val1.contains(val)) {
						return false;
					}
				}
			} else {
				if (!val2.equals(val1))
					return false;
			}
		}
		return true;

	}

}
