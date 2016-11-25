package ua.teachme;

import ua.teachme.model.MainGoal;
import ua.teachme.model.User;

// todo: fix to more transparent code
//todo: change to listener of user or user TO
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private static User user;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        update(user);
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

/*
    private static void setMainGoal(User user) {
        MainGoal transferMainGoal = user.getMainGoal();
        if (null != transferMainGoal) {
            mainGoal = transferMainGoal;
        }
        else {
            mainGoal = new MainGoal();
        }
    }
*/

    public static void update(User user){
        LoggedUser.user = user;
//        setMainGoal(user);
    }

    public static User getUser() {
        return user;
    }

    public static int getId() {
        return user.getId();
    }

    public static String getName() {
        return user.getName();
    }

    public static MainGoal getMainGoal() {
        return user.getMainGoal();
    }
}