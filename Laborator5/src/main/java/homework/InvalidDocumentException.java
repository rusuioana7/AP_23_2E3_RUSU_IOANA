package homework;

public class InvalidDocumentException extends Exception {
    public InvalidDocumentException(String errorDocument) {
        super(errorDocument);
    }
}
