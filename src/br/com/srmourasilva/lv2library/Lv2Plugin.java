package br.com.srmourasilva.lv2library;

import java.util.ArrayList;
import java.util.List;

public class Lv2Plugin {
	private String uri;
	private int instanceNumber;

	private ArrayList<Lv2Param> params;

	public Lv2Plugin(String uri) {
		this.uri = uri;
		this.params = new ArrayList<>();
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

	public List<Lv2Param> getParams() {
		return params;
	}

	public void addParam(Lv2Param param) {
		this.params.add(param);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(uri).append(": \n")
			   .append(params);

		return builder.toString();
	}
}
