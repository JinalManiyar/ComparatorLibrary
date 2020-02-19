package com.ComparatorLibrary.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public class JsonParseUtil {

	//object mapper to parse and deserialize json
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	public Map<String, String> parseResponse(String response) {
		
		Map<String, String> responseMap = new HashMap<>();
		
		//readtree to check type of jsonnode
		try {
			addKeys("", objectMapper.readTree(response), responseMap);   
 		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseMap;
	}

	private  void addKeys(String currentPath, JsonNode jsonNode, Map<String, String> responseMap) {   

		// Check if jsonnode is object
		if (jsonNode.isObject()) {
			ObjectNode objectNode = (ObjectNode) jsonNode;
			Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
			String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

			while (iter.hasNext()) {
				Map.Entry<String, JsonNode> entry = iter.next();
				addKeys(pathPrefix + entry.getKey(), entry.getValue(), responseMap);
			}
		} 
		
		//Check if JSONnode is array to go through reposnse having array within objects
		else if (jsonNode.isArray()) {
			ArrayNode arrayNode = (ArrayNode) jsonNode;
			for (int i = 0; i < arrayNode.size(); i++) {
				addKeys(currentPath, arrayNode.get(i), responseMap);
			}
		} 
		
		//If jsonnode is value 
		else if (jsonNode.isValueNode()) {
			ValueNode valueNode = (ValueNode) jsonNode;
			if (responseMap.containsKey(currentPath)) {
				responseMap.put(currentPath, responseMap.get(currentPath) + "," + valueNode.asText());
			} else {
				responseMap.put(currentPath, valueNode.asText());
			}
		}
	}
	

}
