package pl.org.opi.sdsm.frmwk.util.serde;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Serde {

    public static final String UTF_8 = "UTF-8";
    
    public static void ser(String fileName, Object obj) {
        try {
            serCore(fileName, obj);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            throw new OsfaldRuntimeException("Json serialization", ex);
        }
    }

    public static Object deser(String fileName, Class clazz) {
        try {
            return deserCore(fileName, clazz);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            throw new OsfaldRuntimeException("Json deserialization", ex);
        }
    }
    
    private static void serCore(String fileName, Object obj) throws JsonProcessingException, IOException {
        File f = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        FileUtils.write(f, s, UTF_8);
    }
    
    private static Object deserCore(String fileName, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = objectMapper.readValue(new File(fileName), clazz);
        return obj;
    }
    
}
