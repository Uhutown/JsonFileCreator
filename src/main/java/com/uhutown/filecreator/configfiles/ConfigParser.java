package com.uhutown.filecreator.configfiles;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.uhutown.filecreator.utils.FileReader;
import com.uhutown.filecreator.utils.Files;

public final class ConfigParser {

	public static final Map<String, ChangeConfigParser> CHANGECONFIGS = getChangeConfigs();
	public static final Map<String, DefaultConfigParser> DEFAULTCONFIGS = getDefaultConfigs();
	public static final Map<String, OneSignalConfigParser> ONESIGNALCONFIGS = getOneSignalConfigs();

	private static final Gson GSON = new Gson();

	public static Map<String, ChangeConfigParser> getChangeConfigs() {
		final Map<String, ChangeConfigParser> returnmap = new HashMap<>();

		for (Map.Entry<String, String> entry : FileReader
				.readallFilesfromDierectory(Files.CHANGECONFIGS.getPath(), false).entrySet()) {
			returnmap.put(entry.getKey(), GSON.fromJson(entry.getValue(), ChangeConfigParser.class));
		}
		return returnmap;
	}

	public static Map<String, DefaultConfigParser> getDefaultConfigs() {
		final Map<String, DefaultConfigParser> returnmap = new HashMap<>();

		for (Map.Entry<String, String> entry : FileReader
				.readallFilesfromDierectory(Files.DEFAULTCONFIGS.getPath(), false).entrySet()) {
			returnmap.put(entry.getKey(), GSON.fromJson(entry.getValue(), DefaultConfigParser.class));

		}
		return returnmap;
	}

	public static Map<String, OneSignalConfigParser> getOneSignalConfigs() {
		final Map<String, OneSignalConfigParser> returnmap = new HashMap<>();

		for (Map.Entry<String, String> entry : FileReader
				.readallFilesfromDierectory(Files.SHUNTINGCONFIGS.getPath(), false).entrySet()) {
			returnmap.put(entry.getKey(), GSON.fromJson(entry.getValue(), OneSignalConfigParser.class));
		}
		for (Map.Entry<String, String> entry : FileReader
				.readallFilesfromDierectory(Files.RESETCONFIGS.getPath(), false).entrySet()) {
			returnmap.put(entry.getKey(), GSON.fromJson(entry.getValue(), OneSignalConfigParser.class));
		}
		return returnmap;
	}

}
