package controller.command;

import constant.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return Pages.REGISTRATION_PAGE;
    }
}
