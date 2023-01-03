package com.uhutown.filecreator.utils;

import com.uhutown.filecreator.configfiles.ChangeConfigParser;
import com.uhutown.filecreator.configfiles.DefaultConfigParser;
import com.uhutown.filecreator.configfiles.OneSignalConfigParser;
import com.uhutown.filecreator.modelfiles.ModelStats;
import com.uhutown.filecreator.signalfiles.SignalSystemParser;

@SuppressWarnings("rawtypes")
public enum FileTypes {

	MODELRENDERFILE(ModelStats.class), SIGNALFILE(SignalSystemParser.class), CHANGECONFIG(ChangeConfigParser.class),
	DEFAULTCONFIG(DefaultConfigParser.class), ONESIGNALCONFG(OneSignalConfigParser.class);

	private final Class clazz;

	private FileTypes(final Class clazz) {
		this.clazz = clazz;
	}

	public Class getType() {
		return clazz;
	}

}
