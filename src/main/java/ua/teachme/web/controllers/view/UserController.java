package ua.teachme.web.controllers.view;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.dto.UserTO;
import ua.teachme.model.User;
import ua.teachme.utility.user.UserUtil;
import ua.teachme.web.controllers.AbstractUserController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController extends AbstractUserController {

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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(UserTO userTO) {
        if (0 != userTO.getId()) {
            User user = super.get(userTO.getId());
            super.save(UserUtil.updateUser(user, userTO));
        }
        else {
            super.save(UserUtil.saveUser(userTO));
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("selectedUser", super.get(getIdFromRequest(request)));
        return "user";
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

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }
}
