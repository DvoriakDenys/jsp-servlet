package filter;

import constant.Pages;
import controller.command.CommandType;
import entity.User;
import lombok.NonNull;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

import static controller.command.CommandType.LOGIN;
import static controller.command.CommandType.LOGIN_PAGE;

/**
 * @version 1.0
 */

@WebFilter(urlPatterns = "/*",
        filterName = "AuthFilter")

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String command = servletRequest.getParameter("command");
        final User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (command == null) {
            httpServletRequest.getSession().setAttribute("command", LOGIN_PAGE.toString());
        } else {
            checkUserHasAccess(command, user, httpServletRequest);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void checkUserHasAccess(final @NonNull String command, final User user, final HttpServletRequest servletRequest) {
        switch (getCommandType(command)) {
            case LOGIN:
            case LOGIN_PAGE:
            case LANGUAGE_CHANGE:
            case REGISTRATION_PAGE:
            case REGISTRATION:
                break;
            default:
                if (user == null) {
                    servletRequest.setAttribute("command", LOGIN_PAGE.toString());
                }
        }
    }

    private CommandType getCommandType(final @NonNull String command) {
        return CommandType.valueOf(command.toUpperCase());
    }

    @Override
    public void destroy() {
    }
}
