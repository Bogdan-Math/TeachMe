package ua.teachme.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.dto.UserTO;
import ua.teachme.util.user.UserUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractUserController{

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public String get(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("userID"));
        model.addAttribute("selectedUser", super.get(id));
        return "user";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model){
        model.addAttribute("selectedUser", super.get(getIdFromRequest(request)));
        return "user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(UserTO userTO /*SpringMVC MAGIC !!!*/ /*HttpServletRequest request*/) {
/*
        int id = getIdFromRequest(request);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(id, name, password, email);
*/
        super.save(UserUtil.createUser(userTO));
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        int id = getIdFromRequest(request);
        super.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String getByEmail(HttpServletRequest request, Model model) {
        String email = request.getParameter("userEmail");
        model.addAttribute("selectedUser", super.getByEmail(email));
        return "user";
    }

    @RequestMapping(value = "/notations", method = RequestMethod.GET)
    public String getNotationsByUserId(HttpServletRequest request, Model model){

        return "notations";
    }

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }

}
