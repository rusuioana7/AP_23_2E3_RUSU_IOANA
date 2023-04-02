package homework;


import com.fasterxml.jackson.databind.ObjectMapper;
import homework.Catalog;

import java.io.File;
import java.io.IOException;

public class CatalogExternalOperation {
    public static void save(homework.Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static homework.Catalog load(String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        homework.Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

}
