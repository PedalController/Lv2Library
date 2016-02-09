package br.com.srmourasilva.lv2library.test;

import br.com.srmourasilva.lv2library.Lv2Library;
import br.com.srmourasilva.lv2library.Lv2Plugin;
import br.com.srmourasilva.lv2library.Lv2PortType;
import br.com.srmourasilva.lv2library.MappingException;

public class ListAll {
	public static void main(String[] args) throws MappingException {
		Lv2Library myLib = Lv2Library.getInstance();
		// Find lv2plugins (and generate json matching)
		
		myLib.initializate();
		
		// Show the plugins effects
		System.out.println("All plugins");
		System.out.println(myLib.getPlugins());
		
		System.out.println("AudioPort of first effect");
		Lv2Plugin plugin = myLib.getPlugins().get(0);
		System.out.println(plugin.getPorts(Lv2PortType.AudioPort, Lv2PortType.OutputPort));
	}
}
