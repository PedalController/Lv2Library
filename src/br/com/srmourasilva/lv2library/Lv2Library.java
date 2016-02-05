package br.com.srmourasilva.lv2library;

import java.util.ArrayList;
import java.util.List;

/**
 * The library contains all the Lv2 plugins installed in
 * the computer
 */
public class Lv2Library {
	
	private static final Lv2Library instance = new Lv2Library();

	public static Lv2Library getInstance() {
		return instance;
	}

	////////////////////////////////////
	
	private List<Lv2Plugin> plugins;
	
	private Lv2Library() {
		plugins = new ArrayList<>();
		initializate();
	}
	
	private void initializate() {
		Lv2Mapper mapper = new Lv2Mapper();
		mapper.map();
		this.plugins = mapper.all();
	}

	public List<Lv2Plugin> getPlugins() {
		return plugins;
	}
}
