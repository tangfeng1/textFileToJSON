package com.raulvillares.textFileToJSON.reader.configuration;

import java.util.LinkedList;
import java.util.List;

public class DelimitedFileConfiguration extends FileConfiguration {
	
	public String fileName;
	List<FieldConfiguration> fields = new LinkedList<FieldConfiguration>();
	public String delimiter = ";";
	
	public DelimitedFileConfiguration(String fileName) {
		super(fileName);
	}	
	
	public DelimitedFileConfiguration(String fileName, String delimiter) {
		super(fileName);
		this.delimiter = delimiter;
	}	
	
	public String getDelimiter() { return this.delimiter; }
	
}
