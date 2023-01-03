package com.uhutown.filecreator.modelfiles;

import java.util.Map;

import com.uhutown.filecreator.utils.ITypeable;

public class ModelExtention implements ITypeable {

	public Map<String, String> extention;

	@Override
	public String getType() {
		return "Model Render File";
	}
}
