package br.com.srmourasilva.lv2library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	public void map() {
		Runtime r = Runtime.getRuntime();
		//StringBuilder builder = new StringBuilder();

		try {
			Process process = r.exec("node "+LIB_FOLDER+"index.js");
			process.waitFor();

			/* // NOT NECCESSARY
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			reader.lines().forEach(line -> builder.append(line));
			reader.close();
			 */
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
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
