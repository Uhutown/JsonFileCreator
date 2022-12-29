package com.uhutown.filecreator.signalfiles;

public class SEPropertyParser {

	private String name;
	private String enumClass;
	private String defaultState;
	private String changeableStage;
	private boolean autoname = false;
	private String dependencies;

	public String getName() {
		return name;
	}

	public String getEnumClass() {
		return enumClass;
	}

	public Object getDefaultState() {
		return defaultState;
	}

	public String getChangeableStage() {
		return changeableStage;
	}

	public boolean isAutoname() {
		return autoname;
	}

	public String getDependencies() {
		return dependencies;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setEnumClass(final String enumClass) {
		this.enumClass = enumClass;
	}

	public void setDefaultState(final String defaultState) {
		this.defaultState = defaultState;
	}

	public void setChangeableStage(final String changeableStage) {
		this.changeableStage = changeableStage;
	}

	public void setAutoname(boolean autoname) {
		this.autoname = autoname;
	}

	public void setDependencies(final String dependencies) {
		this.dependencies = dependencies;
	}

}