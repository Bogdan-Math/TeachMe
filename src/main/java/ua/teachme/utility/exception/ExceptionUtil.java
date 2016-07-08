package ua.teachme.utility.exception;

public class ExceptionUtil {

    public static <T> T check(T enyEntity, int id){
        return check(enyEntity, "id=" + id);
    }

    public static <T> T check(T enyEntity, String message){
        if (null == enyEntity){
            throw new EntityNotFoundException(message);
        }
        return enyEntity;
    }
}