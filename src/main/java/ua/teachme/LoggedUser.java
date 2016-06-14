package ua.teachme;

import ua.teachme.model.MainGoal;
import ua.teachme.model.User;

// todo: fix to more transparent code
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private static int id;
    private static String name;
    private static MainGoal mainGoal;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        id = user.getId();
        name = user.getName();
        setMainGoal(user);
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

    private static void setMainGoal(User user) {
        MainGoal transferMainGoal = user.getMainGoal();
        if (null != transferMainGoal) {
            mainGoal = transferMainGoal;
        }
        else {
            mainGoal = new MainGoal();
        }
    }

    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static MainGoal getMainGoal() {
        return mainGoal;
    }
}