package com.raulvillares.textFileToJSON;

import static org.junit.Assert.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.junit.Test;

import com.raulvillares.textFileToJSON.reader.DelimitedReader;
import com.raulvillares.textFileToJSON.reader.configuration.DelimitedFileConfiguration;
import com.raulvillares.textFileToJSON.reader.configuration.FieldConfiguration;

public class ReaderTest {

	@Test
	public void DelimitedStringsFile() {
		DelimitedFileConfiguration delimitedFileConfig = new DelimitedFileConfiguration("DelimitedTest.txt");
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

}
