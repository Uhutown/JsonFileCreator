package com.uhutown.filecreator.configfiles;

import java.util.List;
import java.util.Map;

public class DefaultConfigParser {

	private String currentSignal;
	private Map<String, String> savedPredicates;
	private Map<String, List<String>> values;

	public String getCurrentSignal() {
		return currentSignal;
	}

	public Map<String, String> getSavedPredicates() {
		return savedPredicates;
	}

	public Map<String, List<String>> getValuesToChange() {
		return values;
	}
}