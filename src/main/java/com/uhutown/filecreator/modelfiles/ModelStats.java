package com.uhutown.filecreator.modelfiles;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.uhutown.filecreator.utils.FileReader;
import com.uhutown.filecreator.utils.Files;
import com.uhutown.filecreator.utils.ITypeable;

public class ModelStats implements ITypeable {

	public Map<String, String> textures;
	public Map<String, Models> models;

	public static transient final Map<String, Object> MODELFILES = getfromJson();

	private static transient final Gson GSON = new Gson();

	public static Map<String, Object> getfromJson() {

		final Map<String, String> entrySet = FileReader.readallFilesfromDierectory(Files.MODELFILES.getPath(), false);

		final Map<String, Object> content = new HashMap<>();

		entrySet.forEach((filename, file) -> {
			if (!filename.endsWith("extention.json")) {
				final ModelStats json = GSON.fromJson(file, ModelStats.class);
				content.put(filename, json);
			} else {
				final ModelExtention json = GSON.fromJson(file, ModelExtention.class);
				content.put(filename, json);
			}
		});
		return content;
	}

	@Override
	public String getType() {
		return "Model Render File";
	}
}