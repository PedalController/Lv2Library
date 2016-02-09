package br.com.srmourasilva.lv2library;

import java.util.LinkedList;
import java.util.List;

public class Lv2Port {
	private String name;

	private float min;
	private float max;
	private float current;

	private List<String> types;

	private String symbol;

	public Lv2Port(String name) {
		this.name = name;
		this.types = new LinkedList<>();
	}

	public float getMin() {
		return min;
	}
	
	public void setMin(float min) {
		this.min = min;
	}
	
	public float getMax() {
		return max;
	}
	
	public void setMax(float max) {
		this.max = max;
	}
	
	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}
	
	public List<String> getTypes() {
		return types;
	}
	
	public void addType(String lv2Type) {
		this.types.add(lv2Type);
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(": ").append("\n")
			   .append(" - symbol").append(": ").append(symbol).append("\n")
			   .append(" - types").append(": ").append(types).append("\n");
		
		if (min < max)
			builder.append(" - Current: ").append(current).append(" [ ").append(min).append(" .. ").append(max).append(" ]").append("\n");		

		return builder.toString();
	}
}
