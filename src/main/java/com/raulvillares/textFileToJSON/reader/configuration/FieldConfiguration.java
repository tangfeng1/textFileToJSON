package com.raulvillares.textFileToJSON.reader.configuration;

public class FieldConfiguration {
	private String name;
	private Type type;
	
	public FieldConfiguration(String name) {
		this.name = name;
		this.type = Type.STRING;
	}
	
	public FieldConfiguration(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() { return this.name; }
	public Type getType() { return this.type; }
}
