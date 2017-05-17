package com.raulvillares.textFileToJSON.reader.configuration;

public class FixedFieldConfiguration extends FieldConfiguration {
	
	private int start = 0;
	private int end = 0;
	
	public FixedFieldConfiguration(String name, int start, int end) {
		super(name);
		this.start = start;
		this.end = end;
	}
	
	public int getStart() { return this.start; }
	public int getEnd() { return this.end; }

}
