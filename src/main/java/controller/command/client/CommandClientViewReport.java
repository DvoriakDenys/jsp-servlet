package controller.command.client;

import constant.Pages;
import controller.command.Command;
import entity.Report;
import service.ReportService;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CommandClientViewReport implements Command {

    private final ReportService reportService;
    private final UserService userService;

    public CommandClientViewReport(ReportService reportService, UserService userService) {
        this.reportService = reportService;
        this.userService = userService;
    }

    @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            int id = Integer.parseInt(request.getParameter("reportId"));

            Report report = reportService.findById(id);
            request.setAttribute("report", report);

//            request.setAttribute("status", report.getStatus().getId().intValue());

            return Pages.CLIENT_REPORT_VIEW;
        }
}
