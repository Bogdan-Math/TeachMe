package ua.teachme.web.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.LoggedUser;
import ua.teachme.dto.MainGoalTO;
import ua.teachme.dto.PasswordTO;
import ua.teachme.dto.UserTO;
import ua.teachme.model.User;
import ua.teachme.service.UserService;
import ua.teachme.util.maingoal.MainGoalUtil;
import ua.teachme.util.password.PasswordUtil;
import ua.teachme.util.user.UserUtil;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getProfile(Model model) {
        model.addAttribute("selectedUser", this.getUser());
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateProfile(UserTO userTO /*SpringMVC MAGIC !!!*/ /*HttpServletRequest request*/) {
/*
        int id = getIdFromRequest(request);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(id, name, password, email);
*/
        User user = this.getUser();
        userService.save(UserUtil.updateUser(user, userTO));
        LoggedUser.update(user);
        return "index";
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    public String changePassword(PasswordTO passwordTO, Model model) {
        User user = this.getUser();

        if (!BCrypt.checkpw(passwordTO.getOldPassword(), user.getPassword())) {
            model.addAttribute("selectedUser", user);
            model.addAttribute("wrongOldPassword", true);
            return "profile";
        }
        if (!passwordTO.getNewPassword().equals(passwordTO.getNewPasswordRepeated())) {
            model.addAttribute("selectedUser", user);
            model.addAttribute("wrongRepeatedPassword", true);
            return "profile";
        }
        user.setPassword(PasswordUtil.encode(passwordTO.getNewPassword()));
        userService.save(user);
        model.addAttribute("successfulChangePassword", true);
        model.addAttribute("selectedUser", user);
        return "profile";
    }

    @RequestMapping(value = "mainGoal", method = RequestMethod.POST)
    public String setMainGoal(MainGoalTO mainGoalTO){
        User user = this.getUser();
        MainGoalUtil.updateMainGoal(user, mainGoalTO);
        userService.save(user);
        LoggedUser.update(user);
        return "index";
    }

    private User getUser(){
        return userService.get(LoggedUser.getId());
    }
}