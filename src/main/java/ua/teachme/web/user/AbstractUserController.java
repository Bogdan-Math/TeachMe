package ua.teachme.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.model.User;
import ua.teachme.service.UserService;

import java.util.List;

public abstract class AbstractUserController {

    @Autowired
    private UserService userService;

    public List<User> getAll(){
        return userService.getAll();
    }

    public User save(User user){
        return userService.save(user);
    }

    public User get(int id){
        return userService.get(id);
    }

    public void delete(int id){
        userService.delete(id);
    }

    public User getByEmail(String email){
        return userService.getByEmail(email);
    }

    public void evictCache(){
        userService.evictCache();
    }

}
