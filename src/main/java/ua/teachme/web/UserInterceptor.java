package ua.teachme.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.teachme.LoggedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // fixing bug: correct page view after many times reloading
        if (null != modelAndView && !modelAndView.isEmpty()) {
            modelAndView.getModelMap().addAttribute("loggedUser", LoggedUser.getUser());
        }
    }

}