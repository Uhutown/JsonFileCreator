package com.uhutown.filecreator.configfiles;

import java.util.List;
import java.util.Map;

public class ChangeConfigParser {

	private String currentSignal;
	private String nextSignal;
	private Map<String, String> savedPredicates;
	private Map<String, List<String>> values;

	public String getCurrentSignal() {
		return currentSignal;
	}

	public String getNextSignal() {
		return nextSignal;
	}

	public Map<String, String> getSavedPredicates() {
		return savedPredicates;
	}

	public Map<String, List<String>> getValuesToChange() {
		return values;
	}
}