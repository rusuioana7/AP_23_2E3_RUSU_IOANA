package homework;

//AddComand is used for adding the documents into the catalog
public class AddCommand implements Command {

    private Catalog catalog;
    private Document document;

    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;

    }

    @Override
    public void executeCommand() throws InvalidDocumentException, InvalidCatalogException {
        catalog.addDocumentInCatalog(document);
    }


}
