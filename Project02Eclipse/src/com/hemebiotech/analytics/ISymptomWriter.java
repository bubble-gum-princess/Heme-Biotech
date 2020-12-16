package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
/**
 * This class handles writing symptoms and occurrences into a file
 * 
 * The implementation order of the symptoms alphabetically
 * 
 * @author faizm
 *
 */
public interface ISymptomWriter {
	
	/**
	 * write symptoms into a file
	 * 
	 * @param mapSymptoms Map of symptoms
	 * @throws IOException if any problem occurs while creating the output file
	 */
	public void writeSymptoms(Map<String, Integer> mapSymptoms) throws IOException;

}
