package homework;

//ListCommand prints the title of the catalog's documents

public class ListCommand implements Command {
    Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void executeCommand() {
        for (Document document : catalog.getDocuments()
        ) {
            //if (document != null)
            System.out.println(document.getTitle());

        }
    }
}
