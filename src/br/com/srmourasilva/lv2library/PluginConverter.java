package br.com.srmourasilva.lv2library;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.eclipsesource.json.JsonValue;

class PluginConverter {

	public Lv2Plugin convert(JsonObject json) {
		String uri = json.get("uri").asString();
		Lv2Plugin plugin = new Lv2Plugin(uri);

		for (Member member : json.get("ports").asObject())
			plugin.addParam(convertPort(member));

		return plugin;
	}

	private Lv2Port convertPort(Member member) {
		Lv2Port port = new Lv2Port(member.getName());

		JsonObject values = member.getValue().asObject();

		for (JsonValue type : values.get("Type").asArray())
			port.addType(type.asString());

		port.setSymbol(values.get("Symbol").asString());

		if (port.getTypes().contains(Lv2PortType.ControlPort.getType())) {
			port.setMin(Float.parseFloat(values.getString("Minimum", "")));
			port.setMax(Float.parseFloat(values.getString("Maximum", "")));
			if (port.getTypes().contains(Lv2PortType.InputPort.getType()))
				port.setCurrent(Float.parseFloat(values.getString("Default", "")));
		}

		return port;
	}

}
