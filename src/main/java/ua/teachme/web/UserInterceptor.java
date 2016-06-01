package ua.teachme.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.teachme.LoggedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*if (null != modelAndView && !modelAndView.isEmpty()) {
            LoggedUser loggedUser = LoggedUser.correctGet();
            if (null != loggedUser) {
                modelAndView.getModelMap().addAttribute("userTo", LoggedUser.get());
            }
        }*/
        modelAndView.getModelMap().addAttribute("loggedUser", LoggedUser.getName());
    }

}