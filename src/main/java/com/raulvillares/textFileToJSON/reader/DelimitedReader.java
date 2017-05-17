package com.raulvillares.textFileToJSON.reader;

import java.net.URL;
import java.io.*;
import javax.json.*;

import com.raulvillares.textFileToJSON.reader.configuration.DelimitedFileConfiguration;

public class DelimitedReader extends Reader {
	
	DelimitedFileConfiguration configuration;
	
	public DelimitedReader(DelimitedFileConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public JsonObject read() {
		try {
			BufferedReader reader = this.getReader();
			JsonObjectBuilder mainObject = Json.createObjectBuilder();
			mainObject.add("", this.readLines(reader));
			reader.close();
			return mainObject.build();
		} catch(Exception e) {
			throw new ReaderException(e.getMessage());
		}
	}
	
		private BufferedReader getReader() throws FileNotFoundException {
			return new BufferedReader(new FileReader(createFileObject(this.configuration.getFileName())));
		}
		
			private File createFileObject(String fileName) {
				URL url = this.getClass().getResource("/"+fileName);
				File file = new File(url.getFile());
				return file;
			}
			
		private JsonArray readLines(BufferedReader reader) throws IOException {
			JsonArrayBuilder mainArray = Json.createArrayBuilder();
			String line = reader.readLine();
			while(line != null) {
				mainArray.add(this.readLine(line));
				line = reader.readLine();
			}
			return mainArray.build();			
		}
		
			private JsonObject readLine(String line) {
				JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
				String[] words = line.split(this.configuration.getDelimiter());
				int fieldIndex = 0;
				for(String word : words) {
					objectBuilder.add(this.configuration.getFieldName(fieldIndex), word);
					++fieldIndex;
				}
				return objectBuilder.build();				
			}
			
}
