package controller.command.client;


import constant.Pages;
import controller.command.Command;
import entity.Report;
import entity.User;
import lombok.RequiredArgsConstructor;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ClientReportListCommand implements Command {
    private final ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        final User user = (User) request.getSession().getAttribute("user");
        List<Report> reports = reportService.findAllReportsByUserId(user.getId());
        request.setAttribute("reports", reports);
        return Pages.CLIENT_REPORT_LIST;
    }

}
