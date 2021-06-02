package hyperquiz.exceptions;

public class EntityDataInvalidException extends Exception{
    public EntityDataInvalidException() {
    }

    public EntityDataInvalidException(String message) {
        super(message);
    }

    public EntityDataInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDataInvalidException(Throwable cause) {
        super(cause);
    }
}
