package homework;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;


public class LoadCommand implements Command {

    private String path;

    public LoadCommand(String path) {

        this.path = path;
    }

    @Override
    public void executeCommand() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
    }
}
