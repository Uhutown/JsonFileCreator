package com.uhutown.filecreator.signalfiles;

import java.util.List;
import java.util.Map;

public class SignalPropertiesBuilder {

	public String placementToolName = "";
	public int defaultHeight = 1;
	public Map<String, Integer> signalHeights;
	public float customNameRenderHeight = -1;
	public Map<String, Float> renderHeights;
	public float signWidth = 22;
	public float offsetX = 0;
	public float offsetY = 0;
	public float signScale = 1;
	public boolean canLink = true;
	public List<Integer> colors;
	public Map<String, SoundPropertyParser> sounds;
	public Map<String, String> redstoneOutputs;

}
