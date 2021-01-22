package controller.command;

import constant.Pages;
import entity.User;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command{

    private final UserService userservice;

    public RegistrationCommand(UserService userservice) {
        this.userservice = userservice;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String lastName = request.getParameter("lastName");
        String firstName= request.getParameter("firstName");
        String middleName= request.getParameter("middleName");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        final User userByEmail = userservice.findUserByEmail(email);

        if (password.length() < 5){
            request.setAttribute("notValidatePassword", "Password must be bigger 5 characters");
            return Pages.REGISTRATION_PAGE;
        }

        if(userByEmail != null){
            request.setAttribute("notValidateEmail", "This email is already registered");
            return Pages.REGISTRATION_PAGE;
        }

        if(!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            request.setAttribute("notValidateEmail", "Invalid email form");
            return Pages.REGISTRATION_PAGE;
        }

        User user = User.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .middleName(middleName)
                .build();

        userservice.saveUser(user);
        return Pages.LOGIN;
    }
}
