package ua.teachme;

import ua.teachme.model.User;

// todo: fix to more transparent code
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private static int id;
    private static String name;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        id = user.getId();
        name = user.getName();
//        System.out.println(this.getAuthorities());
    }
/*
    public static LoggedUser correctGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null == auth) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }


    public static LoggedUser get() {
        LoggedUser user = correctGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }
*/

    public static int getId() {
        return id;
    }

    public static String getName(){
        return name;
    }
}