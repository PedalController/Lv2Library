package br.com.srmourasilva.lv2library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

/**
 * Find all lv2 plugins in the computer
 */
class Lv2Mapper {
	private static final String LIB_FOLDER = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
	private static final String PLUGINS_FOLDER = LIB_FOLDER + File.separator + "plugins" + File.separator;	

	/**
	 * Request to map the plugins instaled
	 * calling node lib/index.js for
	 * generate all the .json plugins
	 */
	public void map() throws MappingException  {
		Runtime r = Runtime.getRuntime();
		Process process = null;

		try {
			process = r.exec("node "+LIB_FOLDER+"index.js");
			//it's legen
			process.waitFor(); //it
			//dary!

			//System.out.println(getStringOf(process.getInputStream()));
			//System.out.println(getStringOf(process.getOutputStream()));
		} catch (InterruptedException | IOException e) {
			throw new MappingException(e);
		}

		try {
			String error = getStringOf(process.getErrorStream());
			if (isError(error))
				throw new MappingException(error.trim());
		} catch (IOException e) {
			throw new MappingException(e);
		}
	}
	
	private boolean isError(String error) throws IOException {
		return error.contains("Error");
	}

	private String getStringOf(InputStream stream) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		reader.lines().forEach(line -> builder.append(line));
		reader.close();

		return builder.toString();
	}
	
	public List<Lv2Plugin> all() {
		List<Lv2Plugin> plugins = new ArrayList<>();
		PluginConverter converter = new PluginConverter();

		try {
			Files.walk(Paths.get(PLUGINS_FOLDER)).forEach(filePath -> {
			    if (!Files.isRegularFile(filePath))
			    	return;

			    System.out.println(filePath);
			    JsonObject json = readJsonPluginOf(filePath);
			    Lv2Plugin plugin = converter.convert(json);
			    plugins.add(plugin);
			});

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return plugins;
	}

	private JsonObject readJsonPluginOf(Path filePath) {
		try {
			Reader reader = new FileReader(filePath.toFile());
			JsonObject value = Json.parse(reader).asObject();
			reader.close();

			return value;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
