package ie.nci.journey.api.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * CustomDateDeserializer
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        long timestamp = jsonParser.getLongValue();
        return new Date(timestamp * 1000);
    }
}
