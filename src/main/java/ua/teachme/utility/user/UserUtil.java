package ua.teachme.utility.user;

import ua.teachme.dto.UserTO;
import ua.teachme.model.User;
import ua.teachme.utility.notation.NotationUtil;
import ua.teachme.utility.password.PasswordUtil;

import java.util.Arrays;
import java.util.List;

public class UserUtil {

    public static User newUser = new User("NewUser", "password", "new-user@gmail.com", NotationUtil.hours);
    public static User equalUser = new User("NewUser", "password", "new-user@gmail.com", NotationUtil.hours);

    public static User admin = new User("Admin", "admin-password", "admin@gmail.com", NotationUtil.hours);
    public static User user = new User("User", "user-password", "user@gmail.com", NotationUtil.hours);
    public static User anonymous = new User("Anonymous", "anonymous-password", "anonymous@gmail.com", NotationUtil.hours);

    public static List<User> users = Arrays.asList(
            admin,
            user,
            anonymous
    );

    public static User updateUser(User user, UserTO userTO){
        user.setName(userTO.getName());
        user.setEmail(userTO.getEmail());
//        user.setPassword(PasswordUtil.encode(userTO.getPassword()));
        user.setMaxHoursPerDay(userTO.getHours());
        return user;
    }

    public static User saveUser(UserTO userTO) {
        return new User(
                userTO.getId(),
                userTO.getName(),
                PasswordUtil.encode(userTO.getPassword()),
                userTO.getEmail(),
                userTO.getHours()
        );
    }
}