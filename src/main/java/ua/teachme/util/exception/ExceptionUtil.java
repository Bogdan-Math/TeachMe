package ua.teachme.util.exception;

public class ExceptionUtil {
    public static <T> T check(T enyEntity, String message){
        if (null == enyEntity){
            throw new EntityNotFoundException(message);
        }
        return enyEntity;
    }
}
