package com.example.readxml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonXML {
	

	public static void main(String[] args) {

		
	InputStream input= JacksonXML.class.getResourceAsStream("/countries.xml");
		XmlMapper mapper= new XmlMapper();
		try {
			List<ReadXMLModel> ls= mapper.readValue(input, new TypeReference<List<ReadXMLModel>>() {});
			
			Map<String, ReadXMLModel> map= ls.stream().collect(Collectors.toMap(ReadXMLModel::getName, Function.identity()));
		
		System.out.println(((ReadXMLModel) map.get("India")).getSubregion());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
