package controller.command;


import constant.Pages;
import entity.Report;
import lombok.RequiredArgsConstructor;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class InspectorReportListCommand implements Command {
    private final ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Report> reports = reportService.findAll();
        request.setAttribute("reports", reports);
        return Pages.INSPECTOR_REPORT_LIST;
    }

}
