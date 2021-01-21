package controller.command;

import constant.Pages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageReportCreateCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.REPORT_ADD;
    }
}
