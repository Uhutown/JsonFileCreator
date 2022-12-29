package com.uhutown.filecreator.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.uhutown.filecreator.main.Main;

public final class FileReader {

	private static FileSystem fileSystemCache = null;

	private FileReader() {
	}

	/**
	 * 
	 * @param directory : The path to the directory you want to read out from the
	 *                  resource folder of this mod
	 * @return a map containing all files, as key the filename and as value the
	 *         content of this file
	 */

	public static Map<String, String> readallFilesfromDierectory(final String directory, final boolean readFromJar) {
		final Map<String, String> files = new HashMap<>();
		Path path;
		if (readFromJar) {
			final Optional<Path> optPath = getRessourceLocation(directory);
			if (optPath.isPresent()) {
				path = optPath.get();
			} else {
				throw new IllegalStateException();
			}
		} else {
			path = Paths.get(directory);
		}
		try {
			final Stream<Path> inputs = Files.list(path);
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

	public static Optional<Path> getRessourceLocation(final String location) {
		String filelocation = location;
		final URL url = Main.class.getResource("/assets/girsignals");
		try {
			if (url != null) {
				final URI uri = url.toURI();
				if ("file".equals(uri.getScheme())) {
					if (!location.startsWith("/"))
						filelocation = "/" + filelocation;

					if (fileSystemCache == null) {
						fileSystemCache = FileSystems.getDefault();
					}

					final URL resource = Main.class.getResource(filelocation);
					if (resource == null)
						return Optional.empty();
					return Optional.of(Paths.get(resource.toURI()));

				} else {
					if (!"jar".equals(uri.getScheme())) {
						return Optional.empty();
					}

					if (fileSystemCache == null) {
						fileSystemCache = FileSystems.newFileSystem(uri, Collections.emptyMap());
					}
					return Optional.of(fileSystemCache.getPath(filelocation));
				}
			}
		} catch (final IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}