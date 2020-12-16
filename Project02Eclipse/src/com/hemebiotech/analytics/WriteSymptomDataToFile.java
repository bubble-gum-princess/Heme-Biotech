package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * implementation of symptom writer into file
 * @author faizm
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	public void writeSymptoms(Map<String, Integer> mapSymptoms) throws IOException {
		if (mapSymptoms.isEmpty()) {
			return;
		}
		Map<String, Integer> orderedMapSymptoms = new TreeMap<>(mapSymptoms);
		System.out.println(orderedMapSymptoms);
		FileWriter writer = new FileWriter(filepath);
		for (String s : orderedMapSymptoms.keySet()) {
			Integer symptomCount = orderedMapSymptoms.get(s);
			writer.write(s + ":" + symptomCount + "\n");
		}

		writer.close();

	}

}
