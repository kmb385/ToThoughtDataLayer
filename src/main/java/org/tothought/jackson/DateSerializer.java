package org.tothought.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		String formattedDate = dateFormat.format(date);
		jgen.writeString(formattedDate);
	}

}
