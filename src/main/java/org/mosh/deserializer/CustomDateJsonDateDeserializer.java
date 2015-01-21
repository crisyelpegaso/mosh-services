package org.mosh.deserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class CustomDateJsonDateDeserializer extends
	JsonSerializer<LocalDateTime> {

	private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd' 'HHmmss");
	

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		String formattedDate = FORMATTER.print(date);

		gen.writeString(formattedDate);
	}

}
