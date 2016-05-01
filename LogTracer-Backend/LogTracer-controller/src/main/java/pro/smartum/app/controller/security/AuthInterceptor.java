package pro.smartum.app.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pro.smartum.app.business.UserService;
import pro.smartum.app.business.security.SecurityContextHolder;
import pro.smartum.app.exception.UnauthorizedAccessException;
import pro.smartum.app.exception.UserNotExistsException;
import pro.smartum.app.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * Created by eldar.s on 22.04.2016.
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final String ANON_PATTERN = "/anon";
    private static final String TOKEN_HEADER = "token";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUri = request.getRequestURI();
        if (requestUri.contains(ANON_PATTERN))
            return true;
        else {
            return checkUserToken(request.getHeader(TOKEN_HEADER));
        }
    }

    private boolean checkUserToken(String token) {
        User user = userService.getUserByToken(token);
        if(user == null)
            throw new UnauthorizedAccessException();
        SecurityContextHolder.getInstance().putToken(token);
        SecurityContextHolder.getInstance().putUserId(user.getId());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletRresponsesponse, Object o, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}

