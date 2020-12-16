package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author faizm
 *
 */
public class AnalyticsCounter {

	static final String INPUT_FILE = "D:\\P4 Heme documents\\symptoms.txt";
	static final String OUTPUT_FILE = "D:\\P4 Heme documents\\result.out";

	public static void main(String[] args) throws IOException {
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(INPUT_FILE);
		List<String> symptoms = symptomReader.GetSymptoms();
		System.out.println(symptoms);

		Map<String, Integer> mapSymptoms = symptomCount(symptoms);

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile(OUTPUT_FILE);
		symptomWriter.writeSymptoms(mapSymptoms);
	}

	static Map<String, Integer> symptomCount(List<String> list) {
		Map<String, Integer> mapSymptoms = new HashMap<>();
		for (String s : list) {
			if (mapSymptoms.containsKey(s)) {
				int current = mapSymptoms.get(s);
				current++;
				mapSymptoms.put(s, current);
			} else {
				mapSymptoms.put(s, 1);
			}
		}
		return mapSymptoms;

	}

}