package controller.command.inspector;

import constant.Pages;
import controller.command.Command;
import entity.Report;
import service.ReportService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class InspectorReportListCommand implements Command {
    private final ReportService reportService;

    public InspectorReportListCommand(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pageNumber = 0;
        int quantityReportOnPage = 5;
        int currentPage = 1;
        String status = request.getParameter("status");
        String sorting = request.getParameter("sorting");

        if (request.getParameter("currentPage") != null) {
            pageNumber = (Integer.parseInt(request.getParameter("currentPage")) - 1) * quantityReportOnPage;
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        List<Report> reports = reportService.paginationReport(pageNumber, quantityReportOnPage, sorting, status);

        int quantityPage = (int)Math.ceil((double)reportService.findAll().size() / (double) quantityReportOnPage);

        request.setAttribute("reports", reports);
        request.setAttribute("quantityPage", quantityPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("sorting", sorting);
        request.setAttribute("status", status);

        return Pages.INSPECTOR_REPORT_LIST;
    }
}