package org.tothought.jackson;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts a 10 digit long to a Date for Jackson Deserialization
 * @author Kevin Bowersox
 *
 */
public class LongDateDeserializer extends JsonDeserializer<Date> {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		logger.info("Converting date " + jp.getText());
		logger.info("Converted to: " + new Date(Long.valueOf(jp.getText()) * 1000));
		return new Date(Long.valueOf(jp.getText()) * 1000);
	}

}
