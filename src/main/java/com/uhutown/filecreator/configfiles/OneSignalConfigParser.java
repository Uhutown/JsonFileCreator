package com.uhutown.filecreator.configfiles;

import java.util.List;

import com.uhutown.filecreator.utils.ITypeable;

public class OneSignalConfigParser implements ITypeable {

	public String currentSignal;
	public List<String> values;

	@Override
	public String getType() {
		return "One Signal Config";
	}
}