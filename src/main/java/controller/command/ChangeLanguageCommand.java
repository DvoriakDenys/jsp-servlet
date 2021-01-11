package controller.command;

import constant.Pages;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter("lang");
        if (getCookie(request) != null) {
            Cookie cookie = getCookie(request);
            cookie.setValue(lang);
            response.addCookie(cookie);
        } else {
            response.addCookie(new Cookie("lang", lang));
        }

        return Pages.LOGIN;
    }

    private Cookie getCookie(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("lang")) {
                return cookie;
            }
        }
        return null;
    }

}
