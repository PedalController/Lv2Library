package br.com.srmourasilva.lv2library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lv2Plugin {
	private String uri;
	private int instanceNumber;

	private ArrayList<Lv2Port> ports;

	public Lv2Plugin(String uri) {
		this.uri = uri;
		this.ports = new ArrayList<>();
	}
	
	public String getName() {
		return "effect_" + getInstanceNumber();
	}

	public String getLv2Uri() {
		return uri;
	}
	
	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}

	public List<Lv2Port> getPorts() {
		return ports;
	}
	
	public List<Lv2Port> getPorts(Lv2PortType ...types) {
		List<Lv2Port> portsOfType = new LinkedList<>();
		
		for (Lv2Port lv2Port : this.ports)
			if (isPortContainsTypes(lv2Port, types))
				portsOfType.add(lv2Port);
		
		return portsOfType;
	}

	private boolean isPortContainsTypes(Lv2Port lv2Port, Lv2PortType... types) {
		for (Lv2PortType type : types)
			if (!lv2Port.getTypes().contains(type.getType()))
				return false;

		return true;
	}

	public void addParam(Lv2Port param) {
		this.ports.add(param);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(uri).append(": \n")
			   .append(ports);

		return builder.toString();
	}
}
