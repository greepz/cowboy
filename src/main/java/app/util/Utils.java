package app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private final static Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static <T> String toString(T object){
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.SEVERE, "Ошибка парсинга данных. {0}", e.getMessage());
        }
        return result;
    }


}
