package controller.command;

import constant.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageClientCabinet implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return Pages.CLIENT_CABINET;
    }
}
