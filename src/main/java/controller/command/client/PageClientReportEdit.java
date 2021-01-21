package controller.command.client;

import constant.Pages;
import controller.command.Command;
import entity.Report;
import entity.User;
import service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageClientReportEdit implements Command {

    private final ReportService reportService;

    public PageClientReportEdit(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("reportId"));
        Report report = reportService.findById(id);
        request.setAttribute("report", report);

        return Pages.CLIENT_REPORT_EDIT;
    }
}
