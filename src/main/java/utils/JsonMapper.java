package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import excepciones.MapeoDesdeJsonException;

import java.io.IOException;


public class JsonMapper {
    private ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    public <T> T fromJson(String jsonRead, TypeReference<T> class1) {
        try {
            return this.mapper.readValue(jsonRead, class1);
        } catch (IOException e) {
            throw new MapeoDesdeJsonException(e);
        }
    }

}
