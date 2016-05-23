package ua.teachme.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractUserController{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @RequestMapping(value = "/id", method = RequestMethod.POST)
    public String get(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("userID"));
        model.addAttribute("selectedUser", super.get(id));
        return "user";
    }

    //todo: add 'save' functionality on jsp view
    @Override
    public User save(User user) {
        return super.save(user);
    }

    //todo: add 'delete' functionality on jsp view
    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String getByEmail(HttpServletRequest request, Model model) {
        String email = request.getParameter("userEmail");
        model.addAttribute("selectedUser", super.getByEmail(email));
        return "user";
    }
}
