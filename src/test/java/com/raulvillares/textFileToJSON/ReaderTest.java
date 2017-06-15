package com.raulvillares.textFileToJSON;

import static org.junit.Assert.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import static javax.json.JsonValue.ValueType;

import org.junit.Test;

import com.raulvillares.textFileToJSON.reader.DelimitedReader;
import com.raulvillares.textFileToJSON.reader.configuration.DelimitedFileConfiguration;
import com.raulvillares.textFileToJSON.reader.configuration.FieldConfiguration;

public class ReaderTest {

	@Test
	public void DelimitedStringsFile() {
		DelimitedFileConfiguration delimitedFileConfig = new DelimitedFileConfiguration("DelimitedStringsTest.txt");
		FieldConfiguration fieldConfig1 = new FieldConfiguration("firstName");
		FieldConfiguration fieldConfig2 = new FieldConfiguration("lastName");
		delimitedFileConfig.addField(0, fieldConfig1);
		delimitedFileConfig.addField(1, fieldConfig2);
		DelimitedReader reader = new DelimitedReader(delimitedFileConfig);
		JsonObject actual = reader.read();
		JsonObject object1 = Json.createObjectBuilder().add("firstName", "John").add("lastName", "Smith").build();
		JsonObject object2 = Json.createObjectBuilder().add("firstName", "Peter").add("lastName", "Johnson").build();
		JsonObject object3 = Json.createObjectBuilder().add("firstName", "Mary").add("lastName", "Garcia").build();
		JsonArray mainArray = Json.createArrayBuilder().add(object1).add(object2).add(object3).build();
		JsonObject expected = Json.createObjectBuilder().add("", mainArray).build();
		assertEquals(expected, actual);
	}
	
	@Test
	public void DelimitedIntegersFile() {
		DelimitedFileConfiguration delimitedFileConfig = new DelimitedFileConfiguration("DelimitedIntegersTest.txt");
		FieldConfiguration fieldConfig1 = new FieldConfiguration("year", ValueType.NUMBER);
		FieldConfiguration fieldConfig2 = new FieldConfiguration("worldDeathsByEarthQuake", ValueType.NUMBER);
		delimitedFileConfig.addField(0, fieldConfig1);
		delimitedFileConfig.addField(1, fieldConfig2);
		DelimitedReader reader = new DelimitedReader(delimitedFileConfig);
		JsonObject actual = reader.read();
		JsonObject object1 = Json.createObjectBuilder().add("year", 2010).add("worldDeathsByEarthQuake", 320120).build();
		JsonObject object2 = Json.createObjectBuilder().add("year", 2011).add("worldDeathsByEarthQuake", 21953).build();
		JsonObject object3 = Json.createObjectBuilder().add("year", 2012).add("worldDeathsByEarthQuake", 629).build();
		JsonArray mainArray = Json.createArrayBuilder().add(object1).add(object2).add(object3).build();
		JsonObject expected = Json.createObjectBuilder().add("", mainArray).build();
		assertEquals(expected, actual);
	}	

}
