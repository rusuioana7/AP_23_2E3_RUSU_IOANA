package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;
//

public class ViewCommand implements Command {
    Document document;

    public ViewCommand(Document documentForView) {
        this.document = documentForView;
    }

    @Override
    public void executeCommand() throws InvalidDocumentException, InvalidCatalogException {
        if (document == null) { //checking if the document is null
            throw new InvalidDocumentException("Document is null");
        }


        if (!Desktop.isDesktopSupported()) { //checking if the Desktop class is supported
            throw new InvalidCatalogException("Desktop is not supported");
        }
        Desktop desktop = Desktop.getDesktop();

        if (!desktop.isSupported(Desktop.Action.OPEN)) {
            throw new InvalidCatalogException("OPEN action is not supported");
        }

        File file = new File(document.getPath());

        if (!file.exists()) { //checking if the documents exists
            throw new InvalidDocumentException("File is not found");
        }
        try { //opening the file
            desktop.open(file);
        } catch (IOException e) {
            throw new InvalidCatalogException("Could not open document");
        }
    }

}



