package controller.command;

import constant.Pages;
import entity.Role;
import entity.User;
import factory.ServiceFactory;
import lombok.RequiredArgsConstructor;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RequiredArgsConstructor
public class LoginCommand implements Command {

    private final ServiceFactory serviceFactory;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");


        final UserService userService = serviceFactory.createUserService();
        final User user = userService.findUserByEmail(email);
        final Role userRole = user.getRole();

        if (!user.getPassword().equals(password)) {
            request.setAttribute("errorMessage","Wrong credentials!");
            return Pages.LOGIN;
        }

        String command = request.getParameter("command");

        request.getSession().setAttribute("user", user);

        if (userRole.getRole().equals(Role.INSPECTOR)) {
            return Pages.INSPECTOR_CABINET;
        } else {
            return Pages.CLIENT_CABINET;
        }
    }

}
