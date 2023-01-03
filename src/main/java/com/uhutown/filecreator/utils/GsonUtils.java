package com.uhutown.filecreator.utils;

import com.uhutown.filecreator.configfiles.ConfigParser;
import com.uhutown.filecreator.modelfiles.ModelStats;
import com.uhutown.filecreator.signalfiles.SignalSystemParser;

public final class GsonUtils {

	public static String readFileInfos() {
		System.out.println("Reading out All Files...");
		final StringBuilder builder = new StringBuilder();
		ConfigParser.getChangeConfigs().forEach((filename, content) -> {
			builder.append(filename + ":  " + content.getType() + "\n");
		});
		ConfigParser.getDefaultConfigs().forEach((filename, content) -> {
			builder.append(filename + ":  " + content.getType() + "\n");
		});
		ConfigParser.getOneSignalConfigs().forEach((filename, content) -> {
			builder.append(filename + ":  " + content.getType() + "\n");
		});
		ModelStats.getfromJson().forEach((filename, content) -> {
			builder.append(filename + ": " + ((ITypeable) content).getType() + "\n");
		});
		SignalSystemParser.getSignalSystems().forEach((filename, content) -> {
			builder.append(filename + ":  " + content.getType() + "\n");
		});
		builder.append("\n");
		System.out.println("Read out all Files for Display!");
		return builder.toString();
	}

}
