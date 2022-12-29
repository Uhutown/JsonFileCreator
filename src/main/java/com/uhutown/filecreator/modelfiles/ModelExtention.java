package com.uhutown.filecreator.modelfiles;

import java.util.HashMap;
import java.util.Map;

public class ModelExtention {

	private Map<String, String> extention;

	public Map<String, String> getExtention() {

		if (extention == null)
			extention = new HashMap<>();

		return extention;
	}
}
