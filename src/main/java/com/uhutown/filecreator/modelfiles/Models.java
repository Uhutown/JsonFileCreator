package com.uhutown.filecreator.modelfiles;

import java.util.ArrayList;
import java.util.List;

public class Models {

	private List<TextureStats> textures;
	private float x = 0;
	private float y = 0;
	private float z = 0;

	public float getX(final float xOffset) {
		return x + xOffset;
	}

	public float getY(final float yOffset) {
		return y + yOffset;
	}

	public float getZ(final float zOffset) {
		return z + zOffset;
	}

	public List<TextureStats> getTexture() {

		if (textures == null)
			textures = new ArrayList<>();

		return textures;
	}
}
