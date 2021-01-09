package jsonprocessinglab.jsondemolab.exceptions;

 public class NonExistingEntity extends RuntimeException {
    public NonExistingEntity() {
    }

    public NonExistingEntity(String message) {
        super(message);
    }

    public NonExistingEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistingEntity(Throwable cause) {
        super(cause);
    }
}
