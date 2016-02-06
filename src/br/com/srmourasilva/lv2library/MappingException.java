package br.com.srmourasilva.lv2library;

@SuppressWarnings("serial")
public class MappingException extends Exception {
	public MappingException(String message) {
		super(message);
	}

	public MappingException(Exception e) {
		super(e);
	}
}
