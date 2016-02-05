package br.com.srmourasilva.lv2library;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;

class PluginConverter {

	public Lv2Plugin convert(JsonObject json) {
		Lv2Plugin plugin = new Lv2Plugin("teste");

		for (Member member : json) {
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
