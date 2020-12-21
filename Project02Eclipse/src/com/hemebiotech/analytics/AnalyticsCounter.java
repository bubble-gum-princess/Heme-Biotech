package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * class with main method 
 * @author faizm
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {
		String filePath = AnalyticsCounter.class.getResource("/symptoms.txt").getFile();
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filePath);
		List<String> symptoms = symptomReader.getSymptoms();
		System.out.println(symptoms);

		Map<String, Integer> mapSymptoms = symptomCount(symptoms);

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
		symptomWriter.writeSymptoms(mapSymptoms);
	}

	/**
	 * count number of symptoms from the given list
	 * @param list of symptoms
	 * @return map of occurrences per symptom
	 */
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