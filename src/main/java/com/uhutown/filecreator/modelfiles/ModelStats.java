package com.uhutown.filecreator.modelfiles;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.uhutown.filecreator.utils.FileReader;
import com.uhutown.filecreator.utils.Files;

public class ModelStats {

	private Map<String, String> textures;
	private Map<String, Models> models;

	public Map<String, Models> getModels() {

		if (models == null)
			models = new HashMap<>();

		return models;
	}

	public Map<String, String> getTextures() {
		if (textures == null)
			textures = new HashMap<>();

		return textures;
	}

	public static Map<String, Object> getfromJson() {

		final Gson gson = new Gson();

		final Map<String, String> entrySet = FileReader.readallFilesfromDierectory(Files.MODELFILES.getPath(), false);

		final Map<String, Object> content = new HashMap<>();

		entrySet.forEach((filename, file) -> {
			if (!filename.endsWith("extention.json")) {
				final ModelStats json = gson.fromJson(file, ModelStats.class);
				content.put(filename, json);
			} else {
				final ModelExtention json = gson.fromJson(file, ModelExtention.class);
				content.put(filename, json);
			}
		});
		return content;
	}
}