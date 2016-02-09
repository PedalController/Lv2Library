package br.com.srmourasilva.lv2library;

public enum Lv2PortType {
	AudioPort("http://lv2plug.in/ns/lv2core#AudioPort"),
	AtomPort("http://lv2plug.in/ns/ext/atom#AtomPort"),
	ControlPort("http://lv2plug.in/ns/lv2core#ControlPort"),
	InputPort("http://lv2plug.in/ns/lv2core#InputPort"),
	OutputPort("http://lv2plug.in/ns/lv2core#OutputPort");
	
	private String type;

	private Lv2PortType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
