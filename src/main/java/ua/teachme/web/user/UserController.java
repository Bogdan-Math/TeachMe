package ua.teachme.web.user;

import org.springframework.stereotype.Controller;
import ua.teachme.model.User;

import java.util.List;

@Controller
public class UserController extends AbstractUserController{

    @Override
    public User getByEmail(String email) {
        return super.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }
}
