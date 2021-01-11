package controller.command;

import constant.Pages;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class CommandClientViewReport implements Command{

    private final ReportService reportService;
    private final UserService userService;

        @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            int id = Integer.parseInt(request.getParameter("reportId"));

            Report report = reportService.findById(id);
            request.setAttribute("report", report);

            return Pages.CLIENT_REPORT_VIEW;
        }
}
