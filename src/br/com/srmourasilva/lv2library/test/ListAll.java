package br.com.srmourasilva.lv2library.test;

import br.com.srmourasilva.lv2library.Lv2Library;
import br.com.srmourasilva.lv2library.MappingException;

public class ListAll {
	public static void main(String[] args) {
		Lv2Library myLib = Lv2Library.getInstance();
		// Find lv2plugins (and generate json matching)
		try {
			myLib.initializate();
		} catch (MappingException e) {
			e.printStackTrace();
			return;
		}
		
		// Show the plugins effects
		System.out.println(myLib.getPlugins());
	}
}
