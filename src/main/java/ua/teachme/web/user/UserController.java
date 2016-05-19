package ua.teachme.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.model.User;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractUserController{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public User getByEmail(String email) {
        return super.getByEmail(email);
    }

    @Override
    public void evictCache() {
        super.evictCache();
    }
}
