package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileReader {

    private static ObjectMapper mapperJson = new ObjectMapper(new JsonFactory());

    public static List<User> jsonFileToArrayUsers(File file) throws IOException {
        List<User> jsonUserList = mapperJson.readValue(file, new TypeReference<List<User>>() {
        });
        return jsonUserList;
    }


    public static <T> T mapJSONToObject(File file, Class<T> objectClass) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(file, objectClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}