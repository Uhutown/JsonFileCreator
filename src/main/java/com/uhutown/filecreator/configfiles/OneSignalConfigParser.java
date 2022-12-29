package com.uhutown.filecreator.configfiles;

import java.util.List;

public class OneSignalConfigParser {

	private String currentSignal;
	private List<String> values;

	public String getCurrentSignal() {
		return currentSignal;
	}

	public List<String> getValues() {
		return values;
	}

	public void setCurrentSignal(final String currentSignal) {
		this.currentSignal = currentSignal;
	}

	public void setValues(final List<String> values) {
		this.values = values;
	}

	public void addValue(final String value) {
		values.add(value);
	}
}