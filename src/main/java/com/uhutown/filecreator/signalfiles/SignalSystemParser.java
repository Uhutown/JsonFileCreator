package com.uhutown.filecreator.signalfiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.uhutown.filecreator.utils.FileReader;

public class SignalSystemParser {

	public SignalPropertiesBuilder systemProperties;
	public List<SEPropertyParser> seProperties;

	private static transient final Gson GSON = new Gson();

	public List<SEPropertyParser> getSEProperties() {
		return seProperties;
	}

	public static Map<String, SignalSystemParser> getSignalSystems() {

		final Map<String, String> systems = FileReader.readallFilesfromDierectory("", false);

		final Map<String, SignalSystemParser> properties = new HashMap<>();

		if (systems.isEmpty()) {
			return properties;
		}

		systems.forEach((name, property) -> {
			properties.put(name, GSON.fromJson(property, SignalSystemParser.class));
		});

		return properties;
	}
}