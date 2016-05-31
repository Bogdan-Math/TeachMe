package ua.teachme;

import ua.teachme.model.User;

// todo: fix to more transparent code
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private static int id;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        id = user.getId();
//        System.out.println(this.getAuthorities());
    }
/*
    private static LoggedUser correctGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }


    private static LoggedUser get() {
        LoggedUser user = correctGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }
*/

    public static int getId() {
        return id;
    }
}