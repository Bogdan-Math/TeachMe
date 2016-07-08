package ua.teachme.utility.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message +  " entity not found.");
    }
}