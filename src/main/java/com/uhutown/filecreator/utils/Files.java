package com.uhutown.filecreator.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Files {

	public static final File CHANGECONFIGS = new File("jsonfilecreator/configfiles/changeconfigs");
	public static final File DEFAULTCONFIGS = new File("jsonfilecreator/configfiles/defaultconfigs");
	public static final File SHUNTINGCONFIGS = new File("jsonfilecreator/configfiles/shuntingconfigs");
	public static final File RESETCONFIGS = new File("jsonfilecreator/configfiles/resetconfigs");
	public static final File MODELFILES = new File("jsonfilecreator/modelrenderfiles");

	public static void intFiles() {
		final Field[] fields = Files.class.getFields();
		System.out.println("Cheking if directories are present...");
		for (final Field field : fields) {
			final int modifiers = field.getModifiers();
			if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers)) {
				try {
					if (field.get(null) instanceof File) {
						final File file = (File) field.get(null);
						if (!file.exists()) {
							System.out.println("Creating directory: " + file.getPath() + " ...");
							file.mkdirs();
						}
					}
				} catch (final IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("All directoires are present! \nStarting App...");
	}
}