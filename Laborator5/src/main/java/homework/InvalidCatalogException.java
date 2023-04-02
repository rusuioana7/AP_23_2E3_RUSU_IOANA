package homework;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String errorCatalog) {
        super(errorCatalog);
    }
}
