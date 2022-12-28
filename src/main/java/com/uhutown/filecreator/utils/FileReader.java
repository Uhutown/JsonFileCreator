package com.uhutown.filecreator.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public final class FileReader {

	private FileReader() {
	}

	/**
	 * 
	 * @param directory : The path to the directory you want to read out from the
	 *                  resource folder of this mod
	 * @return a map containing all files, as key the filename and as value the
	 *         content of this file
	 */

	public static Map<String, String> readallFilesfromDierectory(final String directory) {
		final Map<String, String> files = new HashMap<>();
		String path = directory;
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		final Path filepath = Paths.get(path);
		try {
			final Stream<Path> inputs = Files.list(filepath);
			inputs.forEach(file -> {
				try {
					final String content = new String(Files.readAllBytes(file));
					final String name = file.getFileName().toString();

					files.put(name, content);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			});
			inputs.close();
			return files;
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return files;
	}
}