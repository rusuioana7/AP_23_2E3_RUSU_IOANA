package homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    Catalog catalog;
    String path;


    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }


    @Override
    public void executeCommand() throws InvalidDocumentException, InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);

    }
}
