package controller.command.inspector;

import constant.Pages;
import controller.command.Command;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RequiredArgsConstructor
public class CommandInspectorViewReport implements Command {

    private final ReportService reportService;
    private final UserService userService;

        @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

            int id = Integer.parseInt(request.getParameter("reportId"));
            Report report = reportService.findById(id);
            final User user = (User) request.getSession().getAttribute("user");

            User user1 = userService.findUserByEmail(user.getEmail());

            request.setAttribute("user", user);
            request.setAttribute("report", report);

            return Pages.INSPECTOR_REPORT_VIEW;
        }
}
