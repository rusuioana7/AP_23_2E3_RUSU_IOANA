package compulsory;

import compulsory.Catalog;
import compulsory.CatalogExternalOperation;
import compulsory.Document;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Catalog catalog = new Catalog("catalog");

        Document carte = new Document("1", "carte.txt", "./catalog.json");
        carte.setPath("./catalog.json");
        carte.addTag("author", "Mihai Eminescu");

        Document articol = new Document("2", "articol.txt", "./catalog.json");
        articol.setUrl("./catalog.json");
        articol.addTag("year", "1999");

        catalog.add(carte);
        catalog.add(articol);

        CatalogExternalOperation.save(catalog, "./catalog.json");

        Catalog catalog1 = CatalogExternalOperation.load("./catalog.json");



        catalog.toString();
        System.out.println(catalog);

    }
}