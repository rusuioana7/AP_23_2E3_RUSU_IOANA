package homework;

import java.io.IOException;

public interface Command {
    public void executeCommand() throws InvalidDocumentException, InvalidCatalogException, IOException;
}
