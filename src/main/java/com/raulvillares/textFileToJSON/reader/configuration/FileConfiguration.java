package com.raulvillares.textFileToJSON.reader.configuration;

import java.util.LinkedList;
import java.util.List;

public abstract class FileConfiguration {
	
	public String fileName;
	List<FieldConfiguration> fields = new LinkedList<FieldConfiguration>();
	
	public FileConfiguration(String fileName) {
		this.fileName = fileName;
	}
	
	public void addField(int fieldIndex, FieldConfiguration field) {
		fields.add(fieldIndex, field);
	}
	
	public FieldConfiguration getField(int fieldIndex) {
		return this.fields.get(fieldIndex);
	}
	
	public String getFileName() { return this.fileName; }
	public String getFieldName(int fieldIndex) { return this.fields.get(fieldIndex).getName(); }
	public Type getFieldType(int fieldIndex) { return this.fields.get(fieldIndex).getType(); }

}
