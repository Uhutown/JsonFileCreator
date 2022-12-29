package com.uhutown.filecreator.modelfiles;

import java.util.HashMap;
import java.util.Map;

public class TextureStats {

	private float x = 0;
	private float y = 0;
	private float z = 0;

	private boolean loadOFFstate = true;
	private String blockstate;
	private Map<String, String> retexture;
	private Map<String, Map<String, String>> extentions;

	public float getOffsetX() {
		return x;
	}

	public float getOffsetY() {
		return y;
	}

	public float getOffsetZ() {
		return z;
	}

	public boolean loadOFFstate() {
		return loadOFFstate;
	}

	public boolean isautoBlockstate() {
		return blockstate == null;
	}

	public String getBlockstate() {
		return blockstate;
	}

	public Map<String, String> getRetextures() {

		if (retexture == null)
			retexture = new HashMap<>();

		return retexture;
	}

	/**
	 * 1. String: Name of the file to get load 2. String: SEProperty 3. String: The
	 * key of the retexture map
	 */
	public Map<String, Map<String, String>> getExtentions() {

		if (extentions == null) {
			extentions = new HashMap<>();
		}
		return extentions;
	}
}