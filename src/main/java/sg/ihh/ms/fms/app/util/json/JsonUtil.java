package sg.ihh.ms.fms.app.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper objMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT);

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {}

    public static String toJson(Object obj) {
        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toJson", e);
        }
        return "";
    }

    public static <T> T fromJson(String json, Class<T> clazz) {

        log.info(json);
        if (objMapper==null){
            log.error("I AM NULL");
        }
        try {
            return objMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error("fromJson", e);
        }

        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception ex) {
            log.error("fromJson", "Could not invoke Default Constructor", ex);
        }

        return null;
    }
}
