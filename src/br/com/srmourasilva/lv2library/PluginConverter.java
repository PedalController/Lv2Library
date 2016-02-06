package br.com.srmourasilva.lv2library;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;

class PluginConverter {

	public Lv2Plugin convert(JsonObject json) {
		String uri = json.get("uri").asString();
		Lv2Plugin plugin = new Lv2Plugin(uri);

		for (Member member : json.get("params").asObject()) {
			Lv2Param param = new Lv2Param(member.getName());

			JsonObject values = member.getValue().asObject();
			param.setMin(Float.parseFloat(values.getString("Minimum", "")));
			param.setMax(Float.parseFloat(values.getString("Maximum", "")));
			param.setCurrent(Float.parseFloat(values.getString("Default", "")));

			plugin.addParam(param);
		}

		return plugin;
	}

}
