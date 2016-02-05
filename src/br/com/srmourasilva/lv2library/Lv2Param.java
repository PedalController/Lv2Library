package br.com.srmourasilva.lv2library;

public class Lv2Param {
	private String name;

	private float min;
	private float max;
	private float current;


	public Lv2Param(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(": ")
			   .append(current)
			   .append(" [ ").append(min).append(" .. ").append(max).append(" ]");		

		return builder.toString();
	}
}
