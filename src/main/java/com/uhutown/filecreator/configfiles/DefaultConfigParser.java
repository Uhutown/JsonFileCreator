package com.uhutown.filecreator.configfiles;

import java.util.List;
import java.util.Map;

import com.uhutown.filecreator.utils.ITypeable;

public class DefaultConfigParser implements ITypeable {

	public String currentSignal;
	public Map<String, String> savedPredicates;
	public Map<String, List<String>> values;

	@Override
	public String getType() {
		return "Default Config";
	}
}