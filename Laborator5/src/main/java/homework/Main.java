package homework;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, InvalidDocumentException {
        //creating a Catalog object
        Catalog catalog = new Catalog("catalog");

        //creating two Document objects
        Document carte = new Document("1", "carte.json", "./carte.json");
        carte.setTitle("carte");
        carte.setPath("./carte.json");
        carte.addTag("author", "Mihai Eminescu");

        Document articol = new Document("2", "articol.json", "./articol.json");
        articol.setTitle("articol");
        articol.setPath("./articol.json");
        articol.addTag("year", "1999");


        //adding the documents in the catalog using AddCommand
        AddCommand document1 = new AddCommand(catalog, carte);
        document1.executeCommand();
        AddCommand document2 = new AddCommand(catalog, articol);
        document2.executeCommand();


        System.out.println("Catalog documents: ");
        //creating the commands
        Command loadCommand = new LoadCommand("./catalog.json");
        Command saveCommand = new SaveCommand(catalog, "./catalog.json");
        Command listCommand = new ListCommand(catalog);
        Command viewCommandCarte = new ViewCommand(carte);
        Command viewCommandArticol = new ViewCommand(articol);
        Command reportCommand = new ReportCommand(catalog);


        //executing the commands
        loadCommand.executeCommand();
        saveCommand.executeCommand();
        listCommand.executeCommand();
        viewCommandCarte.executeCommand();
        viewCommandArticol.executeCommand();
        reportCommand.executeCommand();


    }
}