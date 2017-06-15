package com.raulvillares.textFileToJSON.reader.configuration;

import static javax.json.JsonValue.ValueType;

public class FieldConfiguration {
	private String name;
	private ValueType type;
	
	public FieldConfiguration(String name) {
		this.name = name;
		this.type = ValueType.STRING;
	}
	
	public FieldConfiguration(String name, ValueType type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() { return this.name; }
	public ValueType getType() { return this.type; }
}
